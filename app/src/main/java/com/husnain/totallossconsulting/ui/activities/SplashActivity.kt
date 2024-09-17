package com.husnain.totallossconsulting.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.husnain.totallossconsulting.databinding.ActivitySplashBinding
import com.husnain.totallossconsulting.utils.startActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inIt()
    }

    private fun inIt() {
        setUpSplash()
    }

    private fun setUpSplash() {
        Handler().postDelayed({
            startActivity(AuthActivity::class.java)
        }, 1000)
    }
}