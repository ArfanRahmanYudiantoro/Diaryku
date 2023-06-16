package com.arfan.diaryku.ui.tambah.artikel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arfan.diaryku.R
import com.arfan.diaryku.databinding.ItemArtikelBinding
import com.arfan.diaryku.model.Artikel
import com.arfan.diaryku.network.ArtikelApi
import com.bumptech.glide.Glide

class ArtikelAdapter : RecyclerView.Adapter<ArtikelAdapter.ViewHolder>(){
    private val data = mutableListOf<Artikel>()
    fun updateData(newData: List<Artikel>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
    class ViewHolder(
        private val binding: ItemArtikelBinding
    ) :RecyclerView.ViewHolder(binding.root){
        fun bind(artikel: Artikel) = with(binding){
            tvJudulArtikel.text = artikel.judul
            tvKeterangan.text = artikel.desc

            Glide.with(ivGambarArtikel.context)
                .load(ArtikelApi.getArtikelUrl(artikel.imgId))
                .error(R.drawable.baseline_broken_image_24) .
                into(ivGambarArtikel)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater  = LayoutInflater.from(parent.context)
        val binding = ItemArtikelBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

}