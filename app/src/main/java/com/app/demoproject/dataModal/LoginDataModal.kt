package com.app.demoproject.dataModal

import android.content.Context
import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import com.app.demoproject.BR
import com.app.demoproject.R

class LoginDataModal : BaseObservable() {


    var email: String = ""
        set(value) {
            field = value
            notifyChange()
        }

    var password: String = ""
        set(value) {
            field = value
            notifyChange()
        }

    @Throws(Exception::class)
    fun validateEmail(context: Context) {
        if (TextUtils.isEmpty(email.trim { it <= ' ' }) || !Patterns.EMAIL_ADDRESS.matcher(email.trim { it <= ' ' })
                .matches()
        ) {
            throw Exception(
                context.resources.getString(R.string.please_enter_your_register_email)
            )
        }
        if (TextUtils.isEmpty(email.trim { it <= ' ' })) {
            throw Exception(
                context.resources.getString(R.string.please_enter_your_password)
            )
        }
    }


}