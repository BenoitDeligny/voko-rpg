plugins {
    kotlin("jvm")
    application
}

group = "vokorpg"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":sharedkernel"))

    testImplementation(kotlin("test"))
}

application {
    mainClass.set("MainKt")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(23)
}