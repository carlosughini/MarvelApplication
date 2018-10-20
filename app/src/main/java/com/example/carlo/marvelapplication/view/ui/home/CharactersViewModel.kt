package com.example.carlo.marvelapplication.view.ui.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.opengl.Visibility
import android.view.View
import com.example.carlo.marvelapplication.service.model.Character
import com.example.carlo.marvelapplication.service.network.MarvelService
import com.example.carlo.marvelapplication.view.ui.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CharactersViewModel : BaseViewModel() {

    @Inject
    lateinit var marvelApi: MarvelService

    private lateinit var subscription: Disposable

    init {
        loadCharacters()
    }

    private lateinit var characters: MutableLiveData<List<Character>>

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    fun getCharacters(): LiveData<List<Character>> {
        if (!::characters.isInitialized) {
            characters = MutableLiveData()
            loadCharacters()
        }
        return characters

    }


    fun loadCharacters() {
        subscription = marvelApi.getAllCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveCharactersStart() }
                .doOnTerminate { onRetrieveCharactersFinish() }
                .subscribe(
                        { onRetrieveCharactersSuccess() },
                        { onRetrievePostListError() }
                )
    }

    private fun onRetrieveCharactersStart() {
        loadingVisibility.value = View.VISIBLE

    }

    private fun onRetrieveCharactersFinish() {
        loadingVisibility.value = View.GONE

    }

    private fun onRetrieveCharactersSuccess() {

    }

    private fun onRetrievePostListError() {

    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

}