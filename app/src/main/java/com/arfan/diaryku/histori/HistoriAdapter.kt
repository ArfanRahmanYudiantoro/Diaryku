package com.arfan.diaryku.histori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arfan.diaryku.R
import com.arfan.diaryku.databinding.ItemHistoriBinding
import com.arfan.diaryku.db.DataEntity
import com.arfan.diaryku.model.setData

class HistoriAdapter :
        ListAdapter<DataEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK){

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
                holder.bind(getItem(position))
            }

            class ViewHolder(
                private val binding: ItemHistoriBinding
            ) : RecyclerView.ViewHolder(binding.root) {
                fun bind(item: DataEntity) = with(binding) {
                    val HasilData = item.setData()
                    jdlTextView.text =
                        root.context.getString(R.string.jdl_x, item.judul, item.keterangan)
                }
            }
        }

