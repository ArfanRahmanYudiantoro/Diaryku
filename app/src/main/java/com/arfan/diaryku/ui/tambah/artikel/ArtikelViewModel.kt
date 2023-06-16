package com.arfan.diaryku.ui.tambah.artikel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arfan.diaryku.model.Artikel
import com.arfan.diaryku.network.ApiStatus
import com.arfan.diaryku.network.ArtikelApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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

}

