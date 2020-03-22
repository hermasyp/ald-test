package com.catnip.avengersapp.feature.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {


    var isLoginSuccess: MutableLiveData<Boolean> = MutableLiveData()

    fun doLogin(username: String, password: String) {
        //validation should be here
        //but I pass any username and password
        isLoginSuccess.value = username.isNotEmpty() && password.isNotEmpty()
    }
}