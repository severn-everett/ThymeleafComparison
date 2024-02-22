group = "com.severett"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks {
    bootJar {
        enabled = false
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    api("org.springframework.boot:spring-boot-starter-validation")
}
