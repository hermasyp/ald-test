package com.catnip.avengersapp.feature.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.catnip.avengersapp.R
import com.catnip.avengersapp.data.preference.UserPreference
import com.catnip.avengersapp.feature.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var userPreference: UserPreference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupViews()
        setupObserver()
    }

    private fun setupViews() {
        userPreference = UserPreference(this)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        btn_login?.setOnClickListener {
            val username = et_username?.text?.trim().toString()
            val password = et_password?.text?.trim().toString()
            userLogin(username, password)
        }
    }

    private fun setupObserver() {
        loginViewModel.isLoginSuccess.observe(this, Observer {
            if (it) {
                Toast.makeText(this, getString(R.string.txt_sucess_login), Toast.LENGTH_SHORT).show()
                userPreference.isLoggedIn = true
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, getString(R.string.txt_error_login), Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun userLogin(username: String, password: String) {
        var isFormFilled = true
        if (username.isEmpty()) {
            et_username?.error = getString(R.string.txt_error_username_empty)
            isFormFilled = false
        }
        if (password.isEmpty()) {
            et_password?.error = getString(R.string.txt_error_password_empty)
            isFormFilled = false
        }

        if (isFormFilled) {
            loginViewModel.doLogin(username, password)
        }

    }
}
