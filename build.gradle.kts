import com.github.jengelman.gradle.plugins.shadow.ShadowPlugin
import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    `java-library`
    `maven-publish`
    alias(libs.plugins.shadow)
    signing
}

val projectDescription = "Uroria Engine"

subprojects {
    apply<JavaLibraryPlugin>()
    apply<ShadowPlugin>()
    apply<SigningPlugin>()

    group = "com.uroria"
    version = System.getenv("ENGINE_VERSION") ?: "0.0.0"

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