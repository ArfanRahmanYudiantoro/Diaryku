package com.arfan.diaryku.network

import com.arfan.diaryku.model.Artikel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private  const val  BASE_URL = "https://raw.githubusercontent.com/"+
        "ArfanRahmanYudiantoro/Diar/main/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface ArtikelApiService{
    @GET("artikel.json")
    suspend fun getArtikel(): List<Artikel>
}

object ArtikelApi{
    val service : ArtikelApiService by lazy {
        retrofit.create(ArtikelApiService::class.java)
    }
    fun getArtikelUrl(imgId: String): String {
        return "$BASE_URL$imgId.jpeg"
    }

}
enum class ApiStatus { LOADING, SUCCESS, FAILED }


