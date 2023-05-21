package com.arfan.diaryku.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.arfan.diaryku.R
import com.arfan.diaryku.databinding.FragmentTambahBinding
import com.arfan.diaryku.db.DataDb
import com.arfan.diaryku.ui.tambah.TambahViewModelFactory

class TambahFragment: Fragment() {

    private lateinit var binding: FragmentTambahBinding
    private val viewModel: TambahViewModel by lazy {
        val db = DataDb.getInstance(requireContext())
        val factory = TambahViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[TambahViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTambahBinding.inflate(layoutInflater, container, false)
        binding.button2.setOnClickListener {
            tambah()

        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button2.setOnClickListener {
            tambah()

        }
        binding.btnHistori.setOnClickListener {
            findNavController().navigate(
                R.id.action_tambahFragment_to_historiFragment
            )
        }
        viewModel.data.observe(viewLifecycleOwner, {
            if (it == null) return@observe
            Log.d("TambahFragment", "Data tersimpan. ID = ${it.id}")
        })

    }

    private fun tambah() {
        val judul = binding.judulInp.text.toString()
        if (judul.isEmpty()) {
            Toast.makeText(requireContext(), "Judul Invalid", Toast.LENGTH_LONG).show()
            return
        }
        val keterangan = binding.tinggiBadanInp.text.toString()
        if (keterangan.isEmpty()) {
            Toast.makeText(requireContext(), "Keterangan Invalid", Toast.LENGTH_LONG).show()
            return
        }

        viewModel.setData(judul, keterangan)
        Toast.makeText(requireContext(), "Berhasil ditambahkan", Toast.LENGTH_LONG).show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater)
    { super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean { if (item.itemId == R.id.menu_about) {

        findNavController().navigate( R.id.action_tambahFragment_to_aboutFragment3)

        return true
    }
        return super.onOptionsItemSelected(item) }


}
