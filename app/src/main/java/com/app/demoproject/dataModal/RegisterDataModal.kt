package com.app.demoproject.dataModal

import android.content.Context
import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.library.baseAdapters.BR
import com.app.demoproject.MainApplication
import com.app.demoproject.R

class RegisterDataModal : BaseObservable() {
    var first_name: String = ""
        set(value) {
            field = value
            notifyChange()
        }
    var last_name: String = ""
        set(value) {
            field = value
            notifyChange()
        }

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

    var confirmPassword: String = ""
        set(value) {
            field = value
            notifyChange()
        }

    @Throws(Exception::class)
    fun validateRegister(context: Context) {
        if (TextUtils.isEmpty(first_name.trim { it <= ' ' })) {
            throw Exception(
                context.resources.getString(R.string.please_enter_your_first_name)
            )
        } else if (TextUtils.isEmpty(last_name.trim { it <= ' ' })) {
            throw IllegalArgumentException(
                context.resources.getString(R.string.please_enter_your_last_name)
            )
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.trim { it <= ' ' })
                .matches() || TextUtils.isEmpty(email)
        ) {
            throw IllegalArgumentException(
                context.resources.getString(R.string.please_enter_your_email)
            )
        } else if (password == "") {
            throw IllegalArgumentException(
                context.resources.getString(R.string.please_enter_your_password)
            )
        } else if (password.length < 6) {
            throw IllegalArgumentException(
                context.resources.getString(R.string.pass_length)
            )
        } else if (!confirmPassword.contentEquals(password)) {
            throw IllegalArgumentException(
                context.resources.getString(R.string.confirm_password_must_be_same_as_password)
            )
        } else if (MainApplication.dbHelper().checkUserWithEmail(email)) {
            throw IllegalArgumentException(
                context.resources.getString(R.string.already_exist)
            )
        }
    }
}

