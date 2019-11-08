import Versions.androidXCore_version
import Versions.androidXLegacyVersion
import Versions.app_compat_version
import Versions.constrain_layout_version
import Versions.daggerVersion
import Versions.gson_version
import Versions.jUnitVersion
import Versions.koin_version
import Versions.kotlin_version
import Versions.mockitoVersion
import Versions.recyclerViewCK_VERSION
import Versions.retrofit_version
import Versions.rxjava2_version

object Versions {
    const val kotlin_version            = "1.3.41"
    const val app_compat_version        = "1.0.2"
    const val koin_version              = "2.0.1"
    const val constrain_layout_version  = "2.0.0-alpha3"
    const val rxjava2_version           = "2.1.1"
    const val recyclerViewCK_VERSION    = "28.0.0"
    const val gson_version              = "2.8.5"
    const val androidXCore_version      = "1.0.2"
    const val retrofit_version          = "2.6.1"
    const val androidXLegacyVersion     = "1.0.0"
    const val materialGoogle            = "1.0.0-rc02"
    const val daggerVersion             = "2.25.2"
    // Testing
    const val mockitoVersion            = "2.2.0"
    const val jUnitVersion              = "4.12"
}

object Deps {
    const val kotlin              =    "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    const val appCompat           =    "androidx.appcompat:appcompat:$app_compat_version"
    const val constrainLayout     =    "androidx.constraintlayout:constraintlayout:$constrain_layout_version"
    const val gson                =    "com.google.code.gson:gson:$gson_version"
    const val koin                =    "org.koin:koin-android:$koin_version"
    const val rxAndroid           =    "io.reactivex.rxjava2:rxandroid:$rxjava2_version"
    const val rxJava              =    "io.reactivex.rxjava2:rxjava:$rxjava2_version"
    const val recyclerView        =    "com.android.support:recyclerview-v7:$recyclerViewCK_VERSION"
    const val androidXCore        =    "androidx.core:core-ktx:$androidXCore_version"
    const val retrofit            =    "com.squareup.retrofit2:retrofit:$retrofit_version"
    const val androidXLegacy      =    "androidx.legacy:legacy-support-v4:$androidXLegacyVersion"
    const val gsonConvert         =    "com.squareup.retrofit2:converter-gson:$retrofit_version"
    const val rxjava2Adapter      =    "com.squareup.retrofit2:adapter-rxjava2:$retrofit_version"
    const val materialGoogle      =    "com.google.android.material:material:${Versions.materialGoogle}"
    const val dagger              =    "com.google.dagger:dagger:${daggerVersion}"
    const val daggerAndroid       =    "com.google.dagger:dagger-android:${daggerVersion}"
    const val daggerAndroidSupport =   "com.google.dagger:dagger-android-support:${daggerVersion}"
    const val daggerCompilerAndroid =  "com.google.dagger:dagger-android-processor:${daggerVersion}"
    const val daggerCompiler      =    "com.google.dagger:dagger-compiler:${daggerVersion}"
}

object TestDependencies {
    const val junit               =    "junit:junit:${jUnitVersion}"
    const val mockito             =     "com.nhaarman.mockitokotlin2:mockito-kotlin:${mockitoVersion}"
}

object AndroidTestDependencies {
    const val runner              =      "com.android.support.test:runner:1.0.2"
    const val espresso            =      "com.android.support.test.espresso:espresso-core:3.0.2"
}