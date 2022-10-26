package com.practice.mvvmdagger2.di

import androidx.lifecycle.ViewModel
import com.practice.mvvmdagger2.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @ClassKey(MainViewModel::class)
    @IntoMap
    fun getMainViewModel(mainViewModel: MainViewModel):ViewModel
}