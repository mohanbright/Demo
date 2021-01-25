package com.app.demoproject.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.app.demoproject.ui.login.LoginActivity

abstract class BaseActivity<TBinding : ViewDataBinding> :AppCompatActivity(),BaseView{

    lateinit var activity: Activity
    lateinit var basevm: BaseViewModel


    protected lateinit var binding: TBinding



    abstract val layoutRes: Int
        @LayoutRes get

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this@BaseActivity
        binding = DataBindingUtil.setContentView(this, layoutRes)
        basevm = BaseViewModel(this)
        binding.lifecycleOwner = this
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(activity,message,Toast.LENGTH_LONG).show()
    }

    override fun <T : Activity> startActivityWithIntent(c: Class<T>) {
        startActivity(Intent(activity,c))
    }

    override fun loadFragment(containerId: Int, fragment: Fragment) {
        val fragmentTransaction =
            supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(containerId, fragment)
        if (fragment.isAdded) {
            return
        }
        fragmentTransaction.commit()
    }



}