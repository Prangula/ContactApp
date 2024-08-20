plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

}

android {
    namespace = "com.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.myapplication"
        minSdk = 21
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}



dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    val room_version = "2.5.2"

    implementation ("androidx.room:room-runtime:$room_version")
    annotationProcessor ("androidx.room:room-compiler:$room_version")


    // Koin components
    implementation( "io.insert-koin:koin-android:3.3.0")
    implementation ("io.insert-koin:koin-core:3.3.0")

    // Coroutines LifeCycle
    val coroutineVersion = "1.3.9"
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
    implementation( "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")



    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))



}