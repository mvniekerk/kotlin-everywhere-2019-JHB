import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

buildscript {
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.3.50"))
    }
}

plugins {
    kotlin("js") version "1.3.50"
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-js")
}

tasks {
    "compileKotlinJs"(Kotlin2JsCompile::class)  {
        kotlinOptions.outputFile = "${projectDir}/function/index.js"
        kotlinOptions.moduleKind = "commonjs"
        kotlinOptions.sourceMap = true
    }
    "build" {
        doLast {
            project.exec {
                commandLine = "cp package.json function/".split(" ")
            }
        }
    }
}
