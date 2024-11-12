package com.example.authorslist.model

import com.google.gson.annotations.SerializedName

data class Provinsi(

    @SerializedName("id")
    val id: Int,

    @SerializedName("nama")
    val nama: String
)
