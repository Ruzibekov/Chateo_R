package com.ruzibekov.chatapp_r

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

open class BaseFragment(layoutId: Int) : Fragment(layoutId) {
    val authentController = Firebase.auth

    fun navigateTo(id: Int) {
        findNavController().navigate(id)
    }
}