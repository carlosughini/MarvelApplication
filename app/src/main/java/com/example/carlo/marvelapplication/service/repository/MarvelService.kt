package com.example.carlo.marvelapplication.service.repository

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelService {

    @GET("/characters")
    fun getAllCharacters()

    @GET("/characters/{characterId}")
    fun getCharacter(@Path("characterId") characterId: String)

    @GET("/characters/{characterId}/comics")
    fun getCharacterComics(@Path("characterId") characterId: String)

}