package br.com.challenge.view.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.challenge.data.dto.ImageCatsRequestDTO
import br.com.challenge.data.repository.ImageCatsRepository
import br.com.challenge.utils.NetWorkResult
import kotlinx.coroutines.launch

class ImageCatsViewModel(
    private val imageCatsRepository: ImageCatsRepository,
    application: Application
) : BaseViewModel(application) {

    private val _responseImagesCats: MutableLiveData<NetWorkResult<ImageCatsRequestDTO>> =
        MutableLiveData()
    val responseImagesCats: LiveData<NetWorkResult<ImageCatsRequestDTO>> = _responseImagesCats

    fun getImagesCats() = viewModelScope.launch {
        imageCatsRepository.getImagesCats(context).collect {
            _responseImagesCats.value = it
        }
    }
}