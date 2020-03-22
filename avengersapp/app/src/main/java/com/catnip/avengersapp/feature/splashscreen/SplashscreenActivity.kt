package com.catnip.avengersapp.feature.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.catnip.avengersapp.R
import com.catnip.avengersapp.data.preference.UserPreference
import com.catnip.avengersapp.feature.login.LoginActivity
import com.catnip.avengersapp.feature.main.MainActivity

class SplashscreenActivity : AppCompatActivity() {

    private lateinit var userPreference : UserPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        userPreference =  UserPreference(this)
        setupTimer()
    }
    private fun setupTimer(){
        val timer = object: CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }
            override fun onFinish() {
                if(userPreference.isLoggedIn){
                    startActivity(Intent(this@SplashscreenActivity,MainActivity::class.java))
                }else{
                    startActivity(Intent(this@SplashscreenActivity,LoginActivity::class.java))
                }
                finish()
            }
        }
        timer.start()
    }

}
