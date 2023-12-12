package com.d121211103.book

import android.app.Application
import com.d121211103.book.data.AppContainer
import com.d121211103.book.data.DefaultAppContainer

class MyApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}