package com.arfan.diaryku.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataDao {
    @Insert
    fun insert(data: DataEntity)

    @Query("SELECT * FROM data ORDER BY id DESC")
    fun getData(): LiveData<List<DataEntity>>

    @Query("SELECT * FROM data ORDER BY id DESC")
    fun getLastHistory(): LiveData<List<DataEntity>>

    @Query("SELECT * FROM data ORDER BY id DESC LIMIT 1")
    fun getLastHistoryData(): LiveData<DataEntity>
    @Query("DELETE FROM data")
    fun deleteAllHistory()

    @Query("DELETE FROM data WHERE id = :id")
    fun deleteHistory(id: Long)

    @Query("SELECT * FROM data WHERE id = :id")
    fun getHistoryById(id: Long): LiveData<DataEntity>



}