package com.arfan.diaryku.ui.tambah.artikel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.arfan.diaryku.databinding.FragmentArtikelBinding

class ArtikelFragment   : Fragment(){
    private lateinit var binding: FragmentArtikelBinding

    private val viewModel: ArtikelViewModel by lazy {
        ViewModelProvider(this)[ArtikelViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArtikelBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.retrieveData()
    }



}

