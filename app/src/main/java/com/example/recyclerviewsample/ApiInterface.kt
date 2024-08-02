package com.example.recyclerviewsample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


    @GET("v2/top-headlines/")
    fun getArticleData(@Query("country") country: String = "in",
                       @Query("apiKey") apiKey: String = "98b4e1b27e5440e4a36095069d5b46bb") : Call<MyData>
}