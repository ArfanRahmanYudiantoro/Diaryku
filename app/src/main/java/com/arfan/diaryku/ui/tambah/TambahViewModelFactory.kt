package com.arfan.diaryku.ui.tambah

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arfan.diaryku.db.DataDao
import com.arfan.diaryku.ui.TambahViewModel

class TambahViewModelFactory(
    private val db: DataDao
): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TambahViewModel::class.java)){
            return  TambahViewModel(db) as T
        }
        throw IllegalArgumentException("Uknown ViewMOdel class")
    }
}