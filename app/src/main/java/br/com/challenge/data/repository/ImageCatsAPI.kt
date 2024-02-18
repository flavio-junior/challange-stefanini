package br.com.challenge.data.repository

import br.com.challenge.data.dto.ImageCatsRequestDTO
import br.com.challenge.utils.Constants.AUTHORIZATION
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageCatsAPI {
    @Headers("Authorization: $AUTHORIZATION")
    @GET("3/gallery/search/?q=cats&q_type=jpg&q_size_px=small")
    suspend fun getImagesCats(): Response<ImageCatsRequestDTO>
}