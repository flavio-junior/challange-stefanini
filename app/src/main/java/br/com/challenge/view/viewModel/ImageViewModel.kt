package br.com.challenge.view.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.challenge.data.dto.DataRequestDTO
import br.com.challenge.data.repository.ImageRepository
import br.com.challenge.utils.NetWorkResult
import kotlinx.coroutines.launch

class ImageViewModel(
    private val imageRepository: ImageRepository,
    application: Application
) : BaseViewModel(application) {

    private val _responseImagesCats: MutableLiveData<NetWorkResult<DataRequestDTO>> =
        MutableLiveData()
    val responseImagesCats: LiveData<NetWorkResult<DataRequestDTO>> = _responseImagesCats

    fun getWeather(latitude: Double, longitude: Double) = viewModelScope.launch {
        imageRepository.getImagesCats(context).collect {
            _responseImagesCats.value = it
        }
    }

}