package com.arfan.diaryku.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arfan.diaryku.db.DataDao

class HistoriViewModelFactory(
    private val db: DataDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoriViewModel::class.java)) {
            return HistoriViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}