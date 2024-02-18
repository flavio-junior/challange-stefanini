package br.com.challenge.data.repository

class ImageCatsRepositoryImp(
    private val imageCatsAPI: ImageCatsAPI
) {
    suspend fun getImagesCats() = imageCatsAPI.getImagesCats()
}