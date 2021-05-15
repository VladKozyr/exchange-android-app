package com.vlad.kozyr.buildsrc

object App {
    const val BASE_URL = "http://api.exchangeratesapi.io/v1"
    const val ACCESS_KEY = "e1b82364e2497ad73e3e714a30c1f393"
}

object Libraries {

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    const val appCompat = "androidx.appcompat:appcompat:${Versions.androidX}"
    const val androidxCore = "androidx.core:core-ktx:${Versions.androidX}"
    const val androidxLegacy =
        "androidx.legacy:legacy-support-core-utils:${Versions.androidXLegacy}"
    const val androidxAnnotation = "androidx.annotation:annotation:${Versions.androidXAnnotation}"
    const val androidxTest = "androidx.test:core:${Versions.androidXTest}"
    const val ktx = "androidx.core:core-ktx:${Versions.androidX}"

    const val multidex = "com.android.support:multidex:${Versions.multidex}"

    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
    const val koinAndroidCore = "io.insert-koin:koin-android:${Versions.koin}"
    const val koinAndroidExt = "io.insert-koin:koin-android-ext:${Versions.koin}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okhttp3Interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val rxjava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxjava2}"

    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKTX = "androidx.room:room-ktx:${Versions.room}"

    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val googleAndroidMaterial =
        "com.google.android.material:material:${Versions.googleAndroidMaterial}"

    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val testEspresso = "androidx.test.espresso:espresso-core:${Versions.testEspresso}"
}

object Versions {
    const val kotlin = "1.3.41"
    const val gradle = "3.4.1"

    const val androidX = "1.0.2"
    const val androidXAnnotation = "1.1.0"
    const val androidXLegacy = "1.0.0"
    const val androidXTest = "1.0.0"
    const val lifecycle = "2.3.1"
    const val multidex = "1.0.3"
    const val koin = "3.0.1"
    const val coroutines = "1.3.0-M2"
    const val okHttp = "3.12.0"
    const val retrofit = "2.9.0"
    const val room = "2.3.0"
    const val gson = "2.8.5"
    const val rxjava2 = "2.2.4"

    const val constraintLayout = "2.0.4"
    const val googleAndroidMaterial = "1.3.0"

    const val jUnit = "4.12"
    const val testRunner = "1.2.0"
    const val testEspresso = "3.2.0"
}

object Modules {
    const val architecture = ":architecture"
    const val network = ":network"
    const val exchangeApi = ":exchange_api"
}