package com.arfan.diaryku.histori

import androidx.lifecycle.ViewModel
import com.arfan.diaryku.db.DataDao

class HistoriViewModel(db: DataDao) : ViewModel() {
    val data = db.getData()
}