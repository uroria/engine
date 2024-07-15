rootProject.name = "engine"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("versions.toml"))
        }
    }
}

sequenceOf(
    "api",
    "paper",
    "velocity",
    "fabric"
).forEach {
    include("engine-$it")
    project(":engine-$it").projectDir = file(it)
}