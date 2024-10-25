package com.denreyes.puplist

import android.app.Application
import com.denreyes.puplist.di.appModules
import org.koin.core.context.startKoin

class PuplistApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(appModules)
        }
    }
}