package com.example.carlo.marvelapplication.view.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.LinearLayout
import com.example.carlo.marvelapplication.R
import com.example.carlo.marvelapplication.databinding.CharactersFragmentBinding
import com.example.carlo.marvelapplication.extension.inflate
import com.example.carlo.marvelapplication.view.adapter.CharactersAdapter
import kotlinx.android.synthetic.main.characters_fragment.*

class CharactersFragment : Fragment() {

    /**
     * Creates a companion object (static method) to instantiate a new fragment.
     */
    companion object {
        fun newInstanceCharactersFragment() : CharactersFragment {
            return CharactersFragment()
        }
    }

    val animals: ArrayList<String> = ArrayList()

    private val charactersList by lazy {
        characters_list
    }

    private lateinit var viewAdapter: Adapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflates layout for the fragment using extension
        return container?.inflate(R.layout.characters_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        addAnimals()

        /**
         * Improve performance of the recycler view by not requesting a new layout when
         * whenever items are inserted, moved or removed the size.
         */
        charactersList.setHasFixedSize(true)

        /**
         * Set the layout manager responsible for measuring and positioning item views within
         * a Recycler View as well as determining the policy for when to recycle item views
         * that are no longer visible to the user.
         */
        charactersList.layoutManager = LinearLayoutManager(context)

        viewAdapter = CharactersAdapter
    }

    // Adds animals to the empty animals ArrayList
    fun addAnimals() {
        animals.add("dog")
        animals.add("cat")
        animals.add("owl")
        animals.add("cheetah")
        animals.add("raccoon")
        animals.add("bird")
        animals.add("snake")
        animals.add("lizard")
        animals.add("hamster")
        animals.add("bear")
        animals.add("lion")
        animals.add("tiger")
        animals.add("horse")
        animals.add("frog")
        animals.add("fish")
        animals.add("shark")
        animals.add("turtle")
        animals.add("elephant")
        animals.add("cow")
        animals.add("beaver")
        animals.add("bison")
        animals.add("porcupine")
        animals.add("rat")
        animals.add("mouse")
        animals.add("goose")
        animals.add("deer")
        animals.add("fox")
        animals.add("moose")
        animals.add("buffalo")
        animals.add("monkey")
        animals.add("penguin")
        animals.add("parrot")
    }
}