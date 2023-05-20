package com.arfan.diaryku.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.arfan.diaryku.R
import com.arfan.diaryku.databinding.FragmentTambahBinding

class TambahFragment: Fragment() {

    private lateinit var binding: FragmentTambahBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTambahBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

//    private fun updateUI(fragment: TambahFragment){
//        binding = FragmentTambahBinding.inflate(layoutInflater)
//
//    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       // updateUI(fragment = TambahFragment())
    }
}
