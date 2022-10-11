package com.selles.ifindit

import androidx.multidex.MultiDexApplication
import com.selles.ifindit.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FindItApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        val modulesList = listOf(presentationModule)

        startKoin {
            //Koin logguer
//            androidLogger()
            //Declare context
            androidContext(this@FindItApplication)

            //modules
            modules(modulesList)

        }
    }
}