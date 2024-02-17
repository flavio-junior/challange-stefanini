package br.com.challenge.data.dto

import com.google.gson.annotations.SerializedName

data class ImageRequestDTO(
    @SerializedName("link")
    val link: String,
    @SerializedName("images")
    val images: List<ImagesRequestDTO>
)

data class ImagesRequestDTO(
    @SerializedName("link")
    val link: String
)