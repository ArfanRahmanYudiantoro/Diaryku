package com.arfan.diaryku.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataDao {
    @Insert
    fun insert(data: Data)

    @Query("SELECT * FROM data ORDER BY id DESC")
    fun getData(): LiveData<List<Data>>
}