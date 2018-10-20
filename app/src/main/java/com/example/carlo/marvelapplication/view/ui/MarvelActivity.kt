package com.example.carlo.marvelapplication.view.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.example.carlo.marvelapplication.R
import com.example.carlo.marvelapplication.view.ui.home.CharactersFragment
import kotlinx.android.synthetic.main.character_view.*

class MarvelActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.marvel_activity)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            changeFragment(CharactersFragment())
        }
    }

    fun changeFragment(fragment: Fragment, cleanStack: Boolean = false) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        if (cleanStack) {
            clearBackStack()
        }
        fragmentTransaction.setCustomAnimations(
            R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit
        )
        fragmentTransaction.replace(R.id.content_frame, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun clearBackStack() {
        if (fragmentManager.backStackEntryCount > 0) {
            val firstFragment = fragmentManager.getBackStackEntryAt(0)
            fragmentManager.popBackStack(firstFragment.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack()
        } else {
            finish()
        }
    }
}
