package com.arfan.diaryku.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arfan.diaryku.db.Data
import com.arfan.diaryku.db.DataDao
import com.arfan.diaryku.db.HasilData
import com.arfan.diaryku.db.hasilData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TambahViewModel(private val db: DataDao): ViewModel() {
    private val  hasilData = MutableLiveData<HasilData?>()
    private val Data =  MutableLiveData<Data?>()
    val data = db.getData()

    fun setData(judul: String, keterangan: String){
        val data = Data(
            judul = judul,
            keterangan = keterangan
        )
        hasilData.value =  data.hasilData()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = Data(
                    judul = judul,
                    keterangan = keterangan
                )
                db.insert(data)
            }
        }
    }
}