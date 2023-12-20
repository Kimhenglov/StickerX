package com.example.myapplication.service
import com.example.myapplication.model.sticker
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService2 {

    @GET("/provinces.json")
    suspend fun loadProvinceList(): List<sticker>

    @GET("/provinces.json")
    suspend fun loadProvinceList2(): List<sticker>

    @POST("/login")
    suspend fun login(): String

}