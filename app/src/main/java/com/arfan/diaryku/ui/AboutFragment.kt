package com.arfan.diaryku.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arfan.diaryku.R
import com.arfan.diaryku.databinding.FragmentAboutBinding

class AboutFragment : Fragment(R.layout.fragment_about){
    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


}
