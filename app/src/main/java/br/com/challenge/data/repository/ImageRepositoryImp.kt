package br.com.challenge.data.repository

class ImageRepositoryImp(
    private val challengeAPI: ChallengeAPI
) {
    suspend fun getImagesCats() = challengeAPI.getImagesCats()
}