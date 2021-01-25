package com.app.demoproject.ui.login

import android.view.View
import com.app.demoproject.base.BaseViewModel
import com.app.demoproject.ui.register.RegisterActivity

class LoginViewModel(var loginHandler: LoginHandler) : BaseViewModel(loginHandler) {

    /**
     * Open register page
     */
    fun onSignupClick(v: View) {
        loginHandler.startActivityWithIntent(RegisterActivity::class.java)

    }
    
    fun loginClick(v:View){
        loginHandler.onLoginClick()
    }

}