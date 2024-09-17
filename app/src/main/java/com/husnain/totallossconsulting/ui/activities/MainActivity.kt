package com.husnain.totallossconsulting.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.husnain.totallossconsulting.R
import com.husnain.totallossconsulting.databinding.ActivityMainBinding
import com.husnain.totallossconsulting.ui.fragments.home.HomeFragment
import com.husnain.totallossconsulting.utils.BackPressedExtensions.goBackPressed

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.home_nav_host_fragment)!!

        inIt()
    }

    private fun inIt() {
        setupBottomNav()
        handleBackPressed()
    }

    private fun setupBottomNav() {
        binding.lyHome.setOnClickListener {
            navigateToFragment(R.id.homeFragment)
        }

        binding.lySendReferrals.setOnClickListener {
            navigateToFragment(R.id.sendReferralsFragment)
        }
    }

    private fun navigateToFragment(fragmentId: Int) {
        val navController = navHostFragment.findNavController()
        if (navController.currentDestination?.id != fragmentId) {
            navController.navigate(fragmentId)
        }
    }

    private fun handleBackPressed() {
        goBackPressed {
            val currentFragment = navHostFragment.childFragmentManager.fragments.first()
            if (currentFragment is HomeFragment) {
                finishAffinity()  // Exits the app
            } else {
                navHostFragment.findNavController().popBackStack()  // Navigates back
            }
        }
    }
}
