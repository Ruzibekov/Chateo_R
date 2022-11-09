package com.ruzibekov.chatapp_r.screen

import android.content.Context.*
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.ruzibekov.chatapp_r.R
import com.ruzibekov.chatapp_r.databinding.FragmentVerificationBinding


class VerificationFragment : Fragment(R.layout.fragment_verification) {
    private lateinit var binding: FragmentVerificationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentVerificationBinding.bind(view)
        binding.etVerificationNumber.showKeyboard()
    }

    private fun View.showKeyboard() {
        binding.etVerificationNumber.requestFocus()
        val imm = context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.etVerificationNumber, InputMethodManager.SHOW_IMPLICIT)
    }

}