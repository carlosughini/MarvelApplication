package com.example.carlo.marvelapplication.service.network

import com.example.carlo.marvelapplication.service.model.Character
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * The interface which provides methods to get result of webservices.
 */
interface MarvelService {

    /**
     * Get the list of all characters from API
     */
    @GET("/characters")
    fun getAllCharacters(): io.reactivex.Observable<List<Character>>

    @GET("/characters/{characterId}")
    fun getCharacter(@Path("characterId") characterId: String)

    @GET("/characters/{characterId}/comics")
    fun getCharacterComics(@Path("characterId") characterId: String)

}