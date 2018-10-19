package com.example.carlo.marvelapplication.view.ui.home

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import com.example.carlo.marvelapplication.service.model.Character

class CharactersViewModel : ViewModel() {

    val characters = ObservableArrayList<Character>()
    val loadingVisibility = ObservableBoolean(false)

}