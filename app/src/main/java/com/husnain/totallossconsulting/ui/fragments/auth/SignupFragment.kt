package com.husnain.totallossconsulting.ui.fragments.auth

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import com.husnain.totallossconsulting.R
import com.husnain.totallossconsulting.databinding.FragmentSignupBinding
import com.husnain.totallossconsulting.ui.activities.MainActivity
import com.husnain.totallossconsulting.utils.startActivity
import com.husnain.totallossconsulting.utils.toast

class SignupFragment : Fragment() {
    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        // Access the TabLayout
        val tabLayout: TabLayout = binding.lyTab

        // Add tabs programmatically
        tabLayout.addTab(tabLayout.newTab().setText("Yes"))
        tabLayout.addTab(tabLayout.newTab().setText("No"))


        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> toast("Yes Selected")
                    1 -> toast("No Selected")
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    when (tab.position) {
                        0 -> toast("Yes Selected")
                        1 -> toast("No Selected")
                    }
                }
            }
        })

        inIt()
        return binding.root
    }

    private fun inIt() {
        setOnClickListener()
    }

    private fun setOnClickListener() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}