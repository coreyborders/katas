plugins {
    java
    kotlin("jvm") version "1.4.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test-junit5"))

    //This seems unnecessary
    testImplementation("org.mockito.kotlin:mockito-kotlin:2.2.11")

    //This let's gradle build without the ide. This would be needed for ci/cd etc (I think the IDE is cheating for you + 'just working'
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.withType<Test> {
    useJUnitPlatform()
}
