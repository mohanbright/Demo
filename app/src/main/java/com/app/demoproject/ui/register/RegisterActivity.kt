package com.app.demoproject.ui.register

import android.os.Bundle
import com.app.demoproject.MainApplication
import com.app.demoproject.R
import com.app.demoproject.base.BaseActivity
import com.app.demoproject.dataModal.RegisterDataModal
import com.app.demoproject.databinding.ActivityRegisterBinding
import com.app.demoproject.ui.login.LoginActivity
import java.lang.Exception

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(), RegisterHandler {
    override val layoutRes: Int
        get() = R.layout.activity_register
    lateinit var registerModel: RegisterDataModal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this@RegisterActivity
        registerModel = RegisterDataModal()
        basevm = RegisterViewModel(this)
        binding.apply {
            vm = basevm as RegisterViewModel
            request = registerModel
        }
    }

    override fun onRegisterClick() {
        try {
            registerModel.validateRegister(this@RegisterActivity)
            MainApplication.dbHelper()._insertRegister(registerModel)
            startActivityWithIntent(LoginActivity::class.java)
            finish()

        } catch (e: Exception) {
            errorMessage(e)
        }
    }

    private fun errorMessage(e: Exception) {
        when (e.localizedMessage) {
            resources.getString(R.string.please_enter_your_first_name) -> binding.etFirstName.error =
                e.localizedMessage
            resources.getString(R.string.please_enter_your_last_name) -> binding.etLastName.error =
                e.localizedMessage
            resources.getString(R.string.please_enter_your_email) -> binding.etEmail.error =
                resources.getString(R.string.please_enter_your_email)
            resources.getString(R.string.please_enter_your_password) -> binding.etPassword.error =
                resources.getString(R.string.please_enter_your_password)
            resources.getString(R.string.pass_length) -> binding.etPassword.error =
                resources.getString(R.string.pass_length)
            resources.getString(R.string.confirm_password_must_be_same_as_password) -> binding.etConfPass.error =
                resources.getString(R.string.confirm_password_must_be_same_as_password)

        }
    }

}

