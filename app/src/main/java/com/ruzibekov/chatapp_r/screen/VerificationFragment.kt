package com.ruzibekov.chatapp_r.screen

import android.content.Context.*
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.ruzibekov.chatapp_r.BaseFragment
import com.ruzibekov.chatapp_r.R
import com.ruzibekov.chatapp_r.databinding.FragmentVerificationBinding
import java.util.concurrent.TimeUnit


class VerificationFragment : BaseFragment(R.layout.fragment_verification) {
    private lateinit var binding: FragmentVerificationBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentVerificationBinding.bind(view)
        binding.etVerificationPhoneNumber.showKeyboard()
        binding.btnVerification.setOnClickListener { verificateNumber() }
    }

    private fun View.showKeyboard() {
        binding.etVerificationPhoneNumber.requestFocus()
        val imm = context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.etVerificationPhoneNumber, InputMethodManager.SHOW_IMPLICIT)

    }

    private fun verificateNumber(){
        val phoneNumber = "${binding.etVerificationCode}${binding.etVerificationPhoneNumber}" //todo get Phone number for layout
        val options = PhoneAuthOptions.newBuilder(authentController)
            .setPhoneNumber(phoneNumber)       // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(requireActivity())                 // Activity (for callback binding)
            .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            authentController.signInWithCredential(credential)
        }

        override fun onVerificationFailed(e: FirebaseException) {
            Toast.makeText(context, "Xatolik", Toast.LENGTH_SHORT).show()
        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken
        ) {
//            storedVerificationId = verificationId
//            resendToken = tokenk
        }
    }

}