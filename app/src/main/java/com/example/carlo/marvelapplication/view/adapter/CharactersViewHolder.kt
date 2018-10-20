package com.example.carlo.marvelapplication.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.carlo.marvelapplication.service.model.Character
import kotlinx.android.synthetic.main.characters_item.view.*

class CharactersViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    // Holds the TextView that will add each character to
    var character: Character? = null
    set(value) {
        view.character_name_text_view.text = character?.name
    }

}