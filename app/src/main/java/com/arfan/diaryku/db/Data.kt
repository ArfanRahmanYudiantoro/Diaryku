package com.arfan.diaryku.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "data")
data class Data(
    @PrimaryKey(autoGenerate = true)
    var id: Long =0L,
    var judul: String,
    var keterangan: String,
)


fun Data.hasilData(): HasilData{
    return HasilData(judul, keterangan)
}
