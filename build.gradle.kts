import com.github.jengelman.gradle.plugins.shadow.ShadowPlugin
import net.thebugmc.gradle.sonatypepublisher.PublishingType
import net.thebugmc.gradle.sonatypepublisher.SonatypeCentralPortalPublisherPlugin
import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    `java-library`
    `maven-publish`
    alias(libs.plugins.shadow)
    signing
    alias(libs.plugins.sonatypeCentralPortalPublisher)
}

group = "com.uroria"
version = System.getenv("ENGINE_VERSION") ?: "0.0.0"

val projectDescription = "Uroria Engine"

allprojects {
    apply<JavaLibraryPlugin>()

    repositories {
        mavenCentral()
    }

    java.toolchain.languageVersion = JavaLanguageVersion.of(21)

    tasks {
        withType<Test> {
            useJUnitPlatform()

            minHeapSize = "256m"
            maxHeapSize = "512m"
        }

        withType<JavaCompile> {
            options.encoding = "UTF-8"
        }

        withType<Javadoc> {
            (options as? StandardJavadocDocletOptions)?.apply {
                encoding = "UTF-8"

                addBooleanOption("html5", true)
                addStringOption("-release", "21")
                addStringOption("Xdoclint:-missing", "-quiet")
            }
        }

        withType<Jar> {
            duplicatesStrategy = DuplicatesStrategy.INCLUDE
        }

        processResources {
            from(sourceSets.main.get().resources.srcDirs()) {
                filter<ReplaceTokens>("tokens" to mapOf("version" to project.version.toString()))
                filter<ReplaceTokens>("tokens" to mapOf("description" to projectDescription))

                duplicatesStrategy = DuplicatesStrategy.INCLUDE
            }
        }
    }
}

subprojects {
    apply<ShadowPlugin>()
    apply<SonatypeCentralPortalPublisherPlugin>()

    centralPortal {
        username = System.getenv("SONATYPE_USERNAME")
        password = System.getenv("SONATYPE_PASSWORD")

        publishingType = PublishingType.AUTOMATIC

        name = project.name

        pom {
            name = rootProject.name
            url = "https://github.com/uroria/engine"
            description = projectDescription

            licenses {
                license {
                    name = "Apache 2.0"
                    url = "https://github.com/uroria/engine/blob/main/LICENSE"
                }
            }

            developers {
                developer {
                    id = "julian-siebert"
                    name = "Julian Siebert"
                    organization = "Uroria"
                    organizationUrl = "https://github.com/uroria"
                    email = "mail@julian-siebert.de"
                }
            }
            scm {
                connection = "scm:git:git://github.com/uroria/core.git"
                developerConnection = "scm:git:git@github.com:uroria/engine.git"
                url = "https://github.com/uroria/engine"
                tag = "HEAD"
            }

            ciManagement {
                system = "GitHub Actions"
                url = "https://github.com/uroria/engine/actions"
            }
        }
    }

    signing {
        isRequired = System.getenv("CI") != null

        val privateKey = System.getenv("GPG_PRIVATE_KEY")
        val passphrase = System.getenv("GPG_PASSPHRASE")
        useInMemoryPgpKeys(privateKey, passphrase)

        sign(publishing.publications)
    }
}
