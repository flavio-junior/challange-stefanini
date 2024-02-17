package br.com.challenge

import android.app.Application
import br.com.challenge.di.ChallengeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ApplicationMain : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ApplicationMain)
            modules(ChallengeModule)
        }
    }
}