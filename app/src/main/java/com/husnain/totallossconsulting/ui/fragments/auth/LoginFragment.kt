package com.husnain.totallossconsulting.ui.fragments.auth

import android.os.Bundle
import android.os.Handler
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.husnain.totallossconsulting.databinding.FragmentLoginBinding
import com.husnain.totallossconsulting.ui.activities.MainActivity
import com.husnain.totallossconsulting.utils.ProgressDialogUtil.dismissProgressDialog
import com.husnain.totallossconsulting.utils.ProgressDialogUtil.showProgressDialog
import com.husnain.totallossconsulting.utils.startActivity

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        inIt()
        return binding.root
    }

    private fun inIt() {
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.tvLogin.setOnClickListener {
            startActivity(MainActivity::class.java)
//            if (isValid()) {
//                Handler().postDelayed({
//                    dismissProgressDialog()
//                    startActivity(MainActivity::class.java)
//                }, 4000)
//            }
        }
        binding.tvGoBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun isValid(): Boolean {
        val email = binding.etEmail
        val password = binding.etPassword

        email.error = null
        password.error = null
        return when {
            email.text.isNullOrEmpty() -> {
                email.error = "Email required!"
                email.requestFocus()
                false
            }

            password.text.isNullOrEmpty() -> {
                password.error = "Password required!"
                password.requestFocus()
                false
            }

            password.text.toString().length < 7 -> {
                password.error = "Password must be at least 7 characters long"
                password.requestFocus()
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