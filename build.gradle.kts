
plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.ow2.asm:asm:7.1")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa") {
        exclude(group = "org.hibernate", module = "hibernate-core")
    }
    implementation("org.hibernate:hibernate-core:5.4.2.Final")
    testImplementation("org.hsqldb:hsqldb:2.7.1")
}

tasks.test {
    useJUnitPlatform()
}