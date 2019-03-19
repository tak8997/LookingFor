package com.byungtak.lookingfor.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.byungtak.lookingfor.R

fun FragmentActivity.replaceFragment(fragment: Fragment, tag: String = "", frameId: Int)
        = supportFragmentManager
        .beginTransaction()
        .setCustomAnimations(R.anim.pop_enter, R.anim.pop_exit)
        .replace(frameId, fragment)
        .commit()

fun FragmentActivity.replaceFragmentWithourAnimation(fragment: Fragment, tag: String = "", frameId: Int)
        = supportFragmentManager
        .beginTransaction()
        .replace(frameId, fragment)
        .commit()