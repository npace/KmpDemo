plugins {
    id("java-library")
    kotlin("jvm")
    alias(libs.plugins.ktor)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.ktor.server.core.jvm)
    implementation(libs.ktor.server.netty.jvm)
    implementation(libs.ktor.server.status.pages.jvm)
    implementation(libs.ktor.server.default.headers.jvm)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.logback)

    implementation(projects.api)
}
