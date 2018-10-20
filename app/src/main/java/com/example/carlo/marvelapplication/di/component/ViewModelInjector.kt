package com.example.carlo.marvelapplication.di.component

import com.example.carlo.marvelapplication.di.module.NetworkModule
import com.example.carlo.marvelapplication.view.ui.home.CharactersViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    /**
    * Injects required dependencies into the specified PostListViewModel.
    * @param postListViewModel in which to inject the dependencies.
     */
    fun inject(charactersViewModel: CharactersViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }

}