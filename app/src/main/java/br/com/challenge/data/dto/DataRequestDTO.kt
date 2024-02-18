package br.com.challenge.data.dto

import com.google.gson.annotations.SerializedName

data class DataRequestDTO(
    @SerializedName("images")
    val images: List<ImageRequestDTO>
)

data class ImageRequestDTO(
    @SerializedName("type")
    val type: String,
    @SerializedName("link")
    val link: String
)