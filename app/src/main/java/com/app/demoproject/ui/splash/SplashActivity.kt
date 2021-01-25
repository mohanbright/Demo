package com.app.demoproject.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.app.demoproject.R
import com.app.demoproject.base.BaseActivity
import com.app.demoproject.base.BaseView
import com.app.demoproject.base.BaseViewModel
import com.app.demoproject.databinding.ActivitySplashBinding
import com.app.demoproject.session.Session
import com.app.demoproject.ui.login.LoginActivity
import com.app.demoproject.ui.main.MainActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>(), BaseView {
    override val layoutRes: Int
        get() = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this@SplashActivity
        basevm = BaseViewModel(this)
        initSplash()
    }

    fun initSplash() {
        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                performAction()
            }, 5000)
        }
    }

    private fun performAction() {
        if (Session.getInstance()!!.isLogin()) {
            startActivityWithIntent(MainActivity::class.java)
            finish()
        } else {
            startActivityWithIntent(LoginActivity::class.java)
            finish()
        }
    }
}
