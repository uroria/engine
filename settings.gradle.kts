rootProject.name = "engine"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("versions.toml"))
        }
    }
}

include("api")
include("paper")
include("velocity")
include("universal")
include("fabric")