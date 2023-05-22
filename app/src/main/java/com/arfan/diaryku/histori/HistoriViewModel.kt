package com.arfan.diaryku.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arfan.diaryku.db.DataDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
class HistoriViewModel(private val db: DataDao) : ViewModel() {
    val data = db.getData()

    fun hapusData(id: Long) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.deleteHistory(id)
        }
    }
}