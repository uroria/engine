plugins {
    `java-library`
    `maven-publish`
    alias(libs.plugins.shadow)
}

allprojects {
    apply<JavaLibraryPlugin>()

    repositories {
        mavenCentral()
    }
}

dependencies {
    api(project(":api"))
}