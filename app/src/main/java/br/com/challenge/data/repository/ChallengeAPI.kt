package br.com.challenge.data.repository

import br.com.challenge.data.dto.DataRequestDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ChallengeAPI {
    @Headers("Authorization: Client-ID 1ceddedc03a5d71")
    @GET("3/gallery/search/?q=cats")
    suspend fun getImagesCats(): Response<DataRequestDTO>
}