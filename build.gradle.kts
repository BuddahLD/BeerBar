plugins {
//    kotlin("jvm") version "1.9.0"
//    application
    alias(libs.plugins.korge)
}

group = "com.gmail.danylooliinyk"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(8)
}

korge {
    id = "com.gmail.danylooliinyk.Pyvce"

    targetJvm()
    targetAndroid()

    serializationJson()
}
