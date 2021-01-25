package com.app.demoproject.ui.login

import android.os.Bundle
import com.app.demoproject.MainApplication
import com.app.demoproject.R
import com.app.demoproject.base.BaseActivity
import com.app.demoproject.dataModal.LoginDataModal
import com.app.demoproject.databinding.ActivityLoginBinding
import com.app.demoproject.session.Session
import com.app.demoproject.ui.main.MainActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(), LoginHandler {
    override val layoutRes: Int
        get() = R.layout.activity_login

    lateinit var loginDataModal: LoginDataModal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this@LoginActivity
        loginDataModal = LoginDataModal()
        basevm = LoginViewModel(this)
        binding.vm = basevm as LoginViewModel
        binding.request = loginDataModal
    }

    override fun onLoginClick() {
        if (MainApplication.dbHelper().checkUser(loginDataModal.email, loginDataModal.password)) {
            showErrorMessage("Login Successfully!")
            Session.getInstance()!!.userLogin(true)
            startActivityWithIntent(MainActivity::class.java)
            finish()
        } else {
            showErrorMessage("User does not exists!")
        }

    }
}