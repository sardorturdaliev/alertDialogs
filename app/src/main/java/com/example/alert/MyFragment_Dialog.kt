package com.example.alert

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.alert.databinding.FragmentMyDialogBinding

class MyFragment_Dialog : DialogFragment() {
    private lateinit var binding: FragmentMyDialogBinding
    private var click: (() -> Unit)? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyDialogBinding.inflate(layoutInflater)

        binding.btnclick.setOnClickListener {
            click?.invoke()
        }

        return binding.root
    }

    fun setOnClickButton(block : () -> Unit){
        click = block
    }
}