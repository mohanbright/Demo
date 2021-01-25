package com.app.demoproject.ui.register

import android.content.Context
import android.view.View
import com.app.demoproject.base.BaseView
import com.app.demoproject.base.BaseViewModel

class RegisterViewModel(var registerHandler: RegisterHandler) : BaseViewModel(registerHandler){


    public fun registerUser(view:View){
        registerHandler.onRegisterClick()

    }



}