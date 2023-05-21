package com.arfan.diaryku.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arfan.diaryku.db.DataDao
import com.arfan.diaryku.db.DataEntity
import com.arfan.diaryku.model.HasilData
import com.arfan.diaryku.model.setData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TambahViewModel(private val db: DataDao): ViewModel() {
    private val  HasilData = MutableLiveData<HasilData?>()
    fun setData(judul: String, keterangan: String){
        val data = DataEntity(
            judul = judul,
            keterangan = keterangan
        )
        HasilData.value =   data.setData()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = DataEntity(
                    judul = judul,
                    keterangan = keterangan
                )
                db.insert(data)
            }
        }
    }
}