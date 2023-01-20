import org.springframework.boot.gradle.tasks.bundling.BootJar

group = "com.severett"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks {
    withType<BootJar> {
        enabled = false
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    api("org.springframework.boot:spring-boot-starter-validation")
}
