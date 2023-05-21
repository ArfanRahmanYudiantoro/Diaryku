package com.arfan.diaryku.model

import com.arfan.diaryku.db.DataEntity

fun DataEntity.setData():HasilData{
    val data1 = judul+keterangan
    return HasilData(data1)
}