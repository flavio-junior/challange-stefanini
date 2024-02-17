package br.com.challenge.data.dto

import com.google.gson.annotations.SerializedName

data class ImageRequestDTO(
    @SerializedName("link")
    val link: String
)