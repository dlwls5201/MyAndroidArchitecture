package com.tistory.black_jin0427.myandroidarchitecture

import android.app.Application
import com.tistory.black_jin0427.myandroidarchitecture.di.apiModule
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(apiModule))

    }
}
