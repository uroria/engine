repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    api(project(":engine-api"))

    compileOnly(libs.paperApi)
    annotationProcessor(libs.paperApi)

    testImplementation(libs.bundles.junit)
}