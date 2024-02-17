package br.com.challenge.data.repository

import br.com.challenge.data.dto.DataRequestDTO
import br.com.challenge.utils.Constants.AUTHORIZATION
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ChallengeAPI {
    @GET("3/gallery/search/?q=cats")
    suspend fun getImagesCats(
        @Header("Authorization") authorization: String = AUTHORIZATION
    ): Response<DataRequestDTO>
}