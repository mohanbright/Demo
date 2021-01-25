package com.app.demoproject.base

import android.app.Activity
import androidx.fragment.app.Fragment
import com.app.demoproject.ui.fragment.MainFragment

abstract interface BaseView {

    fun showErrorMessage(message:String)

    fun <T : Activity> startActivityWithIntent(c:Class<T>)

    fun loadFragment(containerId:Int,fragment: Fragment)


}