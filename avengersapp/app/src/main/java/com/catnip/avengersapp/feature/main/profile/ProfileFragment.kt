package com.catnip.avengersapp.feature.main.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.catnip.avengersapp.R
import com.catnip.avengersapp.data.preference.UserPreference
import com.catnip.avengersapp.feature.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private lateinit var userPreference: UserPreference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupViews()
    }
    private fun initialize(){
        context?.let {
            userPreference = UserPreference(it)
        }
    }
    private fun setupViews(){
        tv_username?.text = userPreference.username
        btn_logout?.setOnClickListener {
            userPreference.isLoggedIn = false
            userPreference.username = null
            startActivity(Intent(context,LoginActivity::class.java))
            activity?.finish()
        }
    }


}
