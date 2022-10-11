object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinVersion}"
    const val kotlinxSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val multiDex = "androidx.multidex:multidex:${Versions.multidex}"
    const val coreLibDesugaring = "com.android.tools:desugar_jdk_libs:${Versions.coreLibDesugaring}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val lifecycleRuntimeKtx =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.coroutinesLifecycleScopeVersion}"
    const val coroutinesRx2 = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:${Versions.coroutinesVersion}"

    // Support
    const val palette = "androidx.palette:palette:${Versions.palette}"
    const val material = "com.google.android.material:material:${Versions.androidMaterial}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacyV4}"
    const val cardView = "androidx.cardview:cardview:${Versions.supportLibraryLayout}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val androidxAnnotation = "androidx.annotation:annotation:${Versions.androidxAnnotation}"
    const val browser = "androidx.browser:browser:${Versions.androidxBrowser}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayoutVersion}"
    const val preference = "androidx.preference:preference-ktx:${Versions.preference}"
    const val startup = "androidx.startup:startup-runtime:${Versions.startup}"

    const val activityKtx = "androidx.activity:activity-ktx:${Versions.androidxActivityVersion}"
    const val activity = "androidx.activity:activity:${Versions.androidxActivityVersion}"
    const val flexbox = "com.google.android:flexbox:${Versions.flexbox}"

    // LifeCycle
    const val lifecycleReactiveStreams = "androidx.lifecycle:lifecycle-reactivestreams:${Versions.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleProcess = "androidx.lifecycle:lifecycle-process:${Versions.lifecycle}"
    const val lifeCycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"

    // Glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"
    const val glideTransformation = "jp.wasabeef:glide-transformations:${Versions.glideTransformationVersion}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val retrofitKSerializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.retrofitKSerializationConverterVersion}"
    const val retrofitRxJava2Adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitVersion}"

    // OkHttp
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"
    const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpLoggingVersion}"

    // Gson
    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"

    // Koin
    const val koinCore = "io.insert-koin:koin-core:${Versions.koinVersion}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koinVersion}"
    const val koinScope = "io.insert-koin:koin-androidx-scope:${Versions.koinVersion}"
    const val koinViewModel = "io.insert-koin:koin-androidx-viewmodel:${Versions.koinVersion}"

    //Navigation
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.archNavigation}"
    const val navigationRuntimeKtx = "androidx.navigation:navigation-runtime-ktx:${Versions.archNavigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.archNavigation}"

    //Fragment
    const val fragment = "androidx.fragment:fragment:${Versions.fragment}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"

    // Robolectric
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectricVersion}"
    const val robolectricAnnotations = "org.robolectric:annotations:${Versions.robolectricVersion}"

    // Test Android
    const val runner = "androidx.test:runner:${Versions.androidTestVersion}"
    const val rules = "androidx.test:rules:${Versions.androidTestVersion}"

    const val mockwebserver = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebserverVersion}"

    const val koin = "io.insert-koin:koin-test:${Versions.koinVersion}"
    const val assertJ = "org.assertj:assertj-core:${Versions.assertJVersion}"
    const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:${Versions.mockitoKotlin}"
    const val junit = "junit:junit:${Versions.junitTest}"
    const val trust = "com.google.truth:truth:${Versions.trust}"
    const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
    const val junitExt = "androidx.test.ext:junit:${Versions.testExtJunit}"
    const val kotlinTest = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlinVersion}"
    const val kotlinTestJUnit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlinVersion}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"

    const val fragmentTest = "androidx.fragment:fragment-testing:${Versions.fragment}"
    const val core = "androidx.test:core:${Versions.coreTest}"
    const val turbine = "app.cash.turbine:turbine:${Versions.turbine}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val mockkAndroid = "io.mockk:mockk-android:${Versions.mockkAndroid}"

    // Espresso
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
    const val espressoIntents = "androidx.test.espresso:espresso-intents:${Versions.espressoVersion}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espressoVersionDown}"
    const val espressoWeb = "androidx.test.espresso:espresso-web:${Versions.espressoVersion}"
    const val espressoAccessibility = "androidx.test.espresso:espresso-accessibility:${Versions.espressoVersion}"
}