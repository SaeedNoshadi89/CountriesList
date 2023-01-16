plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    kotlin("kapt")
}

android {
    namespace = "com.sn.scaniatest"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.sn.scaniatest"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }

}
secrets {
    defaultPropertiesFileName = "secrets.defaults.properties"
}
dependencies {

    val kotlinVersion by extra("1.7.21")
    val hiltVersion by extra("2.44.2")
    val serializationJsonVersion by extra("1.4.1")
    val coroutineVersion by extra("1.6.4")
    val ktorVersion by extra("2.2.2")
    val navigationVersion by extra("2.5.3")
    val constraintLayoutVersion by extra("2.1.4")
    val shimmerVersion by extra("0.5.0")
    val coilVersion by extra("2.2.2")
    val appcompatVersion by extra("1.6.0")
    val coreVersion by extra("1.9.0")
    val materialVersion by extra("1.7.0")
    val junitVersion by extra("4.13.2")
    val truthVersion by extra("1.1.3")
    val coroutinesTestVersion by extra("1.5.1")
    val junitExtVersion by extra("1.1.5")
    val espressoVersion by extra("3.5.1")
    val turbineVersion by extra("0.12.1")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    implementation("androidx.core:core-ktx:$coreVersion")
    implementation("androidx.appcompat:appcompat:$appcompatVersion")
    implementation("com.google.android.material:material:$materialVersion")
    implementation("androidx.constraintlayout:constraintlayout:$constraintLayoutVersion")
    implementation("androidx.navigation:navigation-fragment-ktx:$navigationVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navigationVersion")
    implementation("io.ktor:ktor-client-core:${ktorVersion}")
    implementation("io.ktor:ktor-client-content-negotiation:${ktorVersion}")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-android:${ktorVersion}")
    implementation("io.ktor:ktor-serialization-gson:$ktorVersion")
    implementation("io.ktor:ktor-client-okhttp:${ktorVersion}")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")
    implementation("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    implementation("com.facebook.shimmer:shimmer:$shimmerVersion")
    implementation("io.coil-kt:coil:$coilVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationJsonVersion")
    testImplementation("junit:junit:$junitVersion")
    testImplementation ("app.cash.turbine:turbine:$turbineVersion")
    testImplementation ("com.google.truth:truth:$truthVersion")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesTestVersion")
    androidTestImplementation("androidx.test.ext:junit:$junitExtVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoVersion")
}