package br.com.challenge.data.repository

import android.content.Context
import br.com.challenge.data.dto.DataRequestDTO
import br.com.challenge.utils.NetWorkResult
import br.com.challenge.utils.toResultFlow
import kotlinx.coroutines.flow.Flow

class ImageRepository(
    private val imageRepositoryImp: ImageRepositoryImp
) {

    suspend fun getImagesCats(
        context: Context
    ): Flow<NetWorkResult<DataRequestDTO>> {
        return toResultFlow(context = context) {
            imageRepositoryImp.getImagesCats()
        }
    }
}