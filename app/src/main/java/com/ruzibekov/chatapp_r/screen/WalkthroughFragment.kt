package com.ruzibekov.chatapp_r.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ruzibekov.chatapp_r.BaseFragment
import com.ruzibekov.chatapp_r.R
import com.ruzibekov.chatapp_r.databinding.FragmentWalkthroughBinding

class WalkthroughFragment : BaseFragment(R.layout.fragment_walkthrough) {
    private lateinit var binding: FragmentWalkthroughBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWalkthroughBinding.bind(view)

        binding.btnWalkthroughStartMessaging.setOnClickListener {
            navigateTo(R.id.action_walkthroughFragment_to_verificationFragment)
        }
    }

}