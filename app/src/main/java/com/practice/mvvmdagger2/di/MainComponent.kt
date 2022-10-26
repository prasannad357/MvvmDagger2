package com.practice.mvvmdagger2.di

import androidx.lifecycle.ViewModel
import com.practice.mvvmdagger2.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface MainComponent {

    fun inject(mainActivity: MainActivity)

    fun getMap():Map<Class<*>,ViewModel>

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance page:Int):MainComponent
    }
}