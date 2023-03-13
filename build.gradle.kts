plugins {
    id("java")
    kotlin("jvm") version "1.8.20-RC"
}

group = "net.timbel"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("kr.dogfoot:hwplib:1.1.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
