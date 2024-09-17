package com.husnain.totallossconsulting.ui.fragments.home

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.husnain.totallossconsulting.R
import com.husnain.totallossconsulting.databinding.FragmentSendReferralsBinding
import com.husnain.totallossconsulting.ui.activities.MainActivity
import com.husnain.totallossconsulting.utils.startActivity

class SendReferralsFragment : Fragment() {
    private var _binding: FragmentSendReferralsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSendReferralsBinding.inflate(inflater, container, false)
        inIt()
        return binding.root
    }

    private fun inIt() {
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.tvSubmit.setOnClickListener {
            if (isValid()){
                startActivity(MainActivity::class.java)
            }
        }
    }

    private fun isValid(): Boolean {
        val name = binding.etName
        val phone = binding.etPhoneNumber
        val email = binding.etClientEmail

        name.error = null
        email.error = null
        phone.error = null

        return when {
            name.text.isNullOrEmpty() -> {
                name.error = "Name required!"
                name.requestFocus()
                false
            }

            email.text.isNullOrEmpty() -> {
                email.error = "Email required!"
                email.requestFocus()
                false
            }

            phone.text.isNullOrEmpty() -> {
                email.error = "Phone required!"
                email.requestFocus()
                false
            }

            !Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches() -> {
                email.error = "Invalid email address!"
                email.requestFocus()
                false
            }

            else -> {
                true
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}