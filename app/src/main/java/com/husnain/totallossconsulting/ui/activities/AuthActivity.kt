package com.husnain.totallossconsulting.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.husnain.totallossconsulting.R
import com.husnain.totallossconsulting.databinding.ActivityAuthBinding
import com.husnain.totallossconsulting.ui.fragments.auth.GetStartedFragment
import com.husnain.totallossconsulting.utils.BackPressedExtensions.goBackPressed

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    private lateinit var navHostFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.auth_nav_host_fragment)!!
        inIt()
    }

    private fun inIt() {
        handleBackPressed()
    }

    private fun handleBackPressed() {
        goBackPressed {
            if (navHostFragment.childFragmentManager.fragments.first() is GetStartedFragment) {
                finishAffinity()
            } else {
                navHostFragment.findNavController().popBackStack()
            }
        }
    }
}