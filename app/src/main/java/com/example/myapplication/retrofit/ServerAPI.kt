package com.example.myapplication.retrofit

import com.example.myapplication.api.FoodStickerList
import com.example.myapplication.pojo.CategoryList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.Locale.Category

interface ServerAPI {
    @GET("random.php")
    fun getRandomFood():retrofit2.Call<FoodStickerList>

    @GET("lookup.php?")
    fun getMealDetails(@Query("1") id:String) : Call<FoodStickerList>

    @GET("filter.png?")
    fun getPopular(@Query("c") categoryName:String) : Call<CategoryList>
}