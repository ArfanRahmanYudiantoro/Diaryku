package com.arfan.diaryku.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arfan.diaryku.R
import com.arfan.diaryku.databinding.FragmentCatatanBinding

class CatatanFragment:Fragment()  {
    private lateinit var binding:FragmentCatatanBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatatanBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button1.setOnClickListener{
            findNavController().navigate(
                R.id.action_catatanFragment_to_tambahFragment
            )
        }


    }


}

