package com.ruzibekov.chatapp_r

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

open class BaseFragment(layoutId: Int) : Fragment(layoutId) {

    fun navigateTo(id: Int) {
        findNavController().navigate(id)
    }
}