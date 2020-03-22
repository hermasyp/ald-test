package com.catnip.avengersapp.feature.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.catnip.avengersapp.data.constant.PASSWORD_MOCKUP
import com.catnip.avengersapp.data.constant.USERNAME_MOCKUP

class LoginViewModel : ViewModel() {


    var isLoginSuccess: MutableLiveData<Boolean> = MutableLiveData()

    fun doLogin(username: String, password: String) {
        isLoginSuccess.value = (username == USERNAME_MOCKUP && password == PASSWORD_MOCKUP)
    }
}