
plugins {
    kotlin("jvm") version "2.1.10"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("org.openjfx:javafx-base:24.0.1:win")
    implementation("org.openjfx:javafx-controls:24.0.1:win")
    implementation("org.openjfx:javafx-graphics:24.0.1:win")
    implementation("org.openjfx:javafx-fxml:24.0.1:win")
}

application {
    mainClass.set("org.example.GestionnaireDepensesGUI")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(23)
}