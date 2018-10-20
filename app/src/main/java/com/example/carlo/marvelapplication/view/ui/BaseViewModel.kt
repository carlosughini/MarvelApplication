package com.example.carlo.marvelapplication.view.ui

import android.arch.lifecycle.ViewModel
import android.net.Network
import com.example.carlo.marvelapplication.di.component.DaggerViewModelInjector
import com.example.carlo.marvelapplication.di.component.ViewModelInjector
import com.example.carlo.marvelapplication.di.module.NetworkModule
import com.example.carlo.marvelapplication.view.ui.home.CharactersViewModel

abstract class BaseViewModel:ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    private fun inject() {
        when(this) {
            is CharactersViewModel -> injector.inject(this)
        }
    }

}