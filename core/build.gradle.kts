plugins {
    java
    kotlin("jvm") version "1.5.0-M1"
}


val gdxVersion = "1.9.13"
val ktxVersion = "1.9.13-b1"

repositories {
    mavenCentral()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    api("com.badlogicgames.gdx:gdx:$gdxVersion")

    api("io.github.libktx:ktx-vis:$ktxVersion")
    api("io.github.libktx:ktx-actors:$ktxVersion")
    api("io.github.libktx:ktx-log:$ktxVersion")
    api("io.github.libktx:ktx-scene2d:$ktxVersion")
    api("io.github.libktx:ktx-style:$ktxVersion")
    api("io.github.libktx:ktx-preferences:$ktxVersion")
    api("io.github.libktx:ktx-vis-style:$ktxVersion")
    api("io.github.libktx:ktx-assets:$ktxVersion")
    api("io.github.libktx:ktx-async:$ktxVersion")
    api("io.github.libktx:ktx-assets-async:$ktxVersion")
    api("io.github.libktx:ktx-app:$ktxVersion")
    api("io.github.libktx:ktx-collections:$ktxVersion")
    api("io.github.libktx:ktx-graphics:$ktxVersion")
    api("io.github.libktx:ktx-i18n:$ktxVersion")
    api("io.github.libktx:ktx-inject:$ktxVersion")
    api("io.github.libktx:ktx-json:$ktxVersion")
    api("io.github.libktx:ktx-math:$ktxVersion")
    api("io.github.libktx:ktx-tiled:$ktxVersion")

    api("com.badlogicgames.ashley:ashley:1.7.3")
    api("io.github.libktx:ktx-ashley:$ktxVersion")

    api("com.badlogicgames.gdx:gdx-freetype:$gdxVersion")
    api("io.github.libktx:ktx-freetype:$ktxVersion")
    api("io.github.libktx:ktx-freetype-async:$ktxVersion")

    api("com.badlogicgames.gdx:gdx-box2d:$gdxVersion")
    api("io.github.libktx:ktx-box2d:$ktxVersion")
}

java {
    group = "org.example"
    version = "1.0-SNAPSHOT"
    sourceCompatibility = JavaVersion.VERSION_15
    targetCompatibility = JavaVersion.VERSION_1_8

}

tasks.withType<JavaCompile>() {
    options.isIncremental = true
    options.encoding = "UTF-8"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks.test {
    useJUnitPlatform()
//    testLogging {
//        events("passed", "skipped", "failed")
//    }
}