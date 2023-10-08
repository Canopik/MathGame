plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //Dagger 2
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.mathgame"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mathgame"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    //Dagger hilt
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("com.google.dagger:hilt-android:2.47")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.room:room-ktx:2.5.2")
    kapt("com.google.dagger:hilt-android-compiler:2.47")
    //Dagger 2
    kapt("com.google.dagger:dagger-compiler:2.47")
    implementation("com.google.dagger:dagger:2.47")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose")
    implementation("androidx.fragment:fragment-ktx:1.6.1")
    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //Room
    annotationProcessor("android.arch.persistence.room:compiler:1.1.1")
    kapt("android.arch.persistence.room:compiler:1.1.1")
    implementation("androidx.room:room-common:2.5.2")
    implementation("androidx.room:room-runtime:2.5.2")
    kapt("androidx.room:room-compiler:2.5.2")
    implementation("androidx.room:room-ktx:2.5.2")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}