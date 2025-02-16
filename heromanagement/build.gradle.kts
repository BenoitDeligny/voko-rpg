plugins {
    kotlin("jvm")
}

group = "vokorpg"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":sharedkernel"))

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}