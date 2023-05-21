package com.arfan.diaryku.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.arfan.diaryku.model.HasilData


@Entity(tableName = "data")
data class DataEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long =0L,
    var judul: String,
    var keterangan: String,
)






