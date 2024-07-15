import net.thebugmc.gradle.sonatypepublisher.PublishingType

plugins {
    alias(libs.plugins.sonatypeCentralPortalPublisher)
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    api(project(":engine-api"))

    compileOnly(libs.paperApi)
    annotationProcessor(libs.paperApi)

    testImplementation(libs.bundles.junit)
}

centralPortal {
    username = System.getenv("SONATYPE_USERNAME")
    password = System.getenv("SONATYPE_PASSWORD")

    publishingType = PublishingType.AUTOMATIC

    name = project.name

    pom {
        name = project.name
        url = "https://github.com/uroria/engine"
        description = "Uroria Engine Paper Implementation"

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
            connection = "scm:git:git://github.com/uroria/engine.git"
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
    val keyPassphrase = System.getenv()["GPG_PASSPHRASE"]
    useInMemoryPgpKeys(privateKey, keyPassphrase)

    sign(publishing.publications)
}