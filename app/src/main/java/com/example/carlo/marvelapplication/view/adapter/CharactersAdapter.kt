package com.example.carlo.marvelapplication.view.adapter

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import com.example.carlo.marvelapplication.R
import com.example.carlo.marvelapplication.R.id.character_name_text_view
import com.example.carlo.marvelapplication.service.model.Character
import kotlinx.android.synthetic.main.characters_item.view.*

class CharactersAdapter(val characters: ArrayList<Character>)
    : RecyclerView.Adapter<CharactersViewHolder>() {


    // Bind each character in the ArrayList to the view
    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.character = characters.get(position)
    }

    /**
     * Called when a ViewHolders are created to fill a RecyclerView.
     *
     * @return A new Charac
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        // Create a variable and get the layoutinflater from context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.characters_item, parent, false)
        // Inflates the item views
        return CharactersViewHolder(view)
    }

    // Return the numbers of characters in the list
    override fun getItemCount(): Int = characters.size



}