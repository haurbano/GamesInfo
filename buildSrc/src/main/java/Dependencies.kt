import Versions.androidXCore_version
import Versions.androidXLegacyVersion
import Versions.app_compat_version
import Versions.constrain_layout_version
import Versions.gson_version
import Versions.koin_version
import Versions.kotlin_version
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
}

object Deps {
    val kotlin              =    "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    val appCompat           =    "androidx.appcompat:appcompat:$app_compat_version"
    val constrainLayout     =    "androidx.constraintlayout:constraintlayout:$constrain_layout_version"
    val gson                =    "com.google.code.gson:gson:$gson_version"
    val koin                =    "org.koin:koin-android:$koin_version"
    val rxAndroid           =    "io.reactivex.rxjava2:rxandroid:$rxjava2_version"
    val rxJava              =    "io.reactivex.rxjava2:rxjava:$rxjava2_version"
    val recyclerView        =    "com.android.support:recyclerview-v7:$recyclerViewCK_VERSION"
    val androidXCore        =    "androidx.core:core-ktx:$androidXCore_version"
    val retrofit            =    "com.squareup.retrofit2:retrofit:$retrofit_version"
    val androidXLegacy      =    "androidx.legacy:legacy-support-v4:$androidXLegacyVersion"
    val gsonConvert         =    "com.squareup.retrofit2:converter-gson:$retrofit_version"
    val rxjava2Adapter      =    "com.squareup.retrofit2:adapter-rxjava2:$retrofit_version"
}

object TestDependencies {
    val junit               =    "junit:junit:4.12"
}

object AndroidTestDependencies {
    val runner              =      "com.android.support.test:runner:1.0.2"
    val espresso            =      "com.android.support.test.espresso:espresso-core:3.0.2"
}