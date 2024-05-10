plugins {
    alias(libs.plugins.harkhark.android.library)
    alias(libs.plugins.harkhark.android.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.harkhark.core.data"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:network"))
    implementation(project(":core:domain"))
    implementation(project(":core:database"))
//    implementation(project(":core:datastore"))    //TODO 에러 발생 > 수정및 확인 필요
}