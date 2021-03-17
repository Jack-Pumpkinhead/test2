import org.gradle.internal.os.OperatingSystem

plugins {
    java
    kotlin("jvm") version "1.5.0-M1"
    application
}

sourceSets.main.configure {
    resources {
        srcDirs += rootProject.file("assets")
    }
}


val mainClassName = "LWJGL3MainKt"
val gdxVersion = "1.9.13"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))

    implementation("com.badlogicgames.gdx:gdx-backend-lwjgl3:$gdxVersion")
    implementation("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-desktop")
    implementation("com.badlogicgames.gdx:gdx-freetype-platform:$gdxVersion:natives-desktop")
    implementation("com.badlogicgames.gdx:gdx-box2d-platform:$gdxVersion:natives-desktop")


//    runtimeOnly(files("../core/build/classes/kotlin/main"))
//    runtimeOnly(files("build/classes/kotlin/main"))
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

tasks.withType<JavaExec>{
    main = mainClassName
    classpath = sourceSets.main.get().runtimeClasspath
    workingDir = rootProject.file("config")
    isIgnoreExitValue = true
    if (OperatingSystem.current() == OperatingSystem.MAC_OS) {
        // Required to run LWJGL3 Java apps on MacOS
        jvmArgs!!.plusAssign("-XstartOnFirstThread")
    }
}

tasks.withType<Jar>{
    dependsOn(configurations.runtimeClasspath)
    from(configurations.runtimeClasspath.get().map{
        if (it.isDirectory) it else zipTree(it)
    })
    manifest{
        attributes["Main-Class"] = mainClassName
    }
    doLast {
        file(archiveFile).setExecutable(true, false)
    }

}
