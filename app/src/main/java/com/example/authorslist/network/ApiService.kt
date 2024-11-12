package com.example.authorslist.network

import com.example.authorslist.model.Authors
import com.example.authorslist.model.Provinsi
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("authors")
    fun getAllAuthors(): Call<List<Authors>>

    @GET("provinsi")
    fun getAllProvinsi(): Call<List<Provinsi>>
}