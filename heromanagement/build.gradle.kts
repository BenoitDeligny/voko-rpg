plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "2.1.10"
}

group = "vokorpg"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":sharedkernel"))

    implementation("com.aallam.ulid:ulid-kotlin:1.3.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")
    implementation("com.aallam.ulid:ulid-kotlin:1.3.0")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("io.kotest:kotest-runner-junit5:5.8.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}