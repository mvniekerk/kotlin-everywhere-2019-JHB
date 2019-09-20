plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.31")
    id("com.github.johnrengelman.shadow").version("5.1.0")
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.amazonaws:aws-lambda-java-core:1.2.0")
}
