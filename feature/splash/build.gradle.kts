plugins {
    alias(libs.plugins.harkhark.android.feature)
    alias(libs.plugins.harkhark.android.library.compose)
}

android {
    namespace = "com.harkhark.feature.splash"
}


dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}