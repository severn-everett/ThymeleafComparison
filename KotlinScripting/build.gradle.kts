group = "com.severett"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val h2Version: String by project
    val kotlinHTMLVersion: String by project
    // Implementation dependencies
    implementation(project(":Common"))
    implementation(kotlin("scripting-common"))
    implementation(kotlin("scripting-jvm"))
    implementation(kotlin("scripting-jvm-host"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:$kotlinHTMLVersion")
    implementation("org.springframework.boot:spring-boot-starter-web")
    // Runtime dependencies
    runtimeOnly("com.h2database:h2:$h2Version")
}
