package br.com.challenge.data.repository

import android.content.Context
import br.com.challenge.data.dto.ImageCatsRequestDTO
import br.com.challenge.utils.NetWorkResult
import br.com.challenge.utils.toResultFlow
import kotlinx.coroutines.flow.Flow

class ImageCatsRepository(
    private val imageCatsRepositoryImp: ImageCatsRepositoryImp
) {

    suspend fun getImagesCats(
        context: Context
    ): Flow<NetWorkResult<ImageCatsRequestDTO>> {
        return toResultFlow(context = context) {
            imageCatsRepositoryImp.getImagesCats()
        }
    }
}