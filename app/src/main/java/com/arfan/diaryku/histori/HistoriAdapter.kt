package com.arfan.diaryku.histori

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arfan.diaryku.R
import com.arfan.diaryku.databinding.ItemHistoriBinding
import com.arfan.diaryku.db.DataDb
import com.arfan.diaryku.db.DataEntity
import com.arfan.diaryku.model.setData
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoriAdapter(val fragment: Fragment) :
        ListAdapter<DataEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<DataEntity>() {
                override fun areItemsTheSame(
                    oldData: DataEntity, newData: DataEntity
                ): Boolean {
                    return oldData.id == newData.id
                }

                override fun areContentsTheSame(
                    oldData: DataEntity, newData: DataEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), holder.itemView)
    }

    class ViewHolder(
        private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DataEntity,view: View) = with(binding) {
            val HasilData = item.setData()
            binding.buttonDelete.setOnClickListener {
                hapusData(item.id, view.context)
            }
            jdlTextView.text =
                root.context.getString(R.string.jdl_x, item.judul, item.keterangan)
        }

        private fun hapusData(id: Long, context: Context) {
            val db = DataDb.getInstance(context)
            val GajiDao = db.dao
            MaterialAlertDialogBuilder(context)
                .setMessage(context.getString(R.string.konfirmasi_hapus_satu))
                .setPositiveButton(context.getString(R.string.hapus)) { _, _ ->
                    CoroutineScope(Dispatchers.IO).launch {
                        withContext(Dispatchers.IO) {
                            GajiDao.deleteHistory(id)
                        }
                    }
                }
                .setNegativeButton(context.getString(R.string.batal)) { dialog, _ ->
                    dialog.cancel()
                }
                .show()
        }
    }
}

