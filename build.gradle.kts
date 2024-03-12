plugins {
    alias(libs.plugins.korge)
}

group = "com.gmail.danylooliinyk"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(11)
}

korge {
    id = "com.gmail.danylooliinyk.beerbar"

    targetJvm()

    serializationJson()
}
