package com.arfan.diaryku.ui.tambah.artikel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.arfan.diaryku.model.Artikel
import com.arfan.diaryku.network.ApiStatus
import com.arfan.diaryku.network.ArtikelApi
import com.arfan.diaryku.network.UpdateWorker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class ArtikelViewModel : ViewModel() {
    private val data = MutableLiveData<List<Artikel>>()
    private val status = MutableLiveData<ApiStatus>()
    init {
        retrieveData()
    }
    fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO){
            status.postValue(ApiStatus.SUCCESS)
            try {
                data.postValue(ArtikelApi.service.getArtikel())
                status.postValue(ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }
    fun getData(): LiveData<List<Artikel>> = data
    fun getStatus(): LiveData<ApiStatus> = status



    fun scheduleUpdater(app: Application) {
        val request = OneTimeWorkRequestBuilder<UpdateWorker>()
            .setInitialDelay(1, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(app).enqueueUniqueWork(
            UpdateWorker.WORK_NAME,
            ExistingWorkPolicy.REPLACE,
            request
        )
    }

}

