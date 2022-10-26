package com.practice.mvvmdagger2

import android.app.Application
import com.practice.mvvmdagger2.di.DaggerMainComponent
import com.practice.mvvmdagger2.di.MainComponent

class MainApplication:Application(){
    lateinit var mainComponent: MainComponent
    override fun onCreate() {
        super.onCreate()

        mainComponent = DaggerMainComponent.factory().create(1)
    }
}