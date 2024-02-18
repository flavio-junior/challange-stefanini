package br.com.challenge.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.challenge.data.dto.DataRequestDTO
import br.com.challenge.databinding.ActImageBinding
import br.com.challenge.utils.ApiResultHandler
import br.com.challenge.view.adapter.ImageAdapter
import br.com.challenge.view.viewModel.ImageViewModel
import org.koin.android.ext.android.inject

class ImageActivity : AppCompatActivity() {

    private lateinit var binding: ActImageBinding
    private val viewModel: ImageViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getImagesCats()
        observeRequest()
    }

    private fun getImagesCats() {
        viewModel.getImagesCats()
    }

    private fun observeRequest() {
        try {
            viewModel.responseImagesCats.observe(this@ImageActivity) { response ->
                val apiResultHandler = ApiResultHandler<DataRequestDTO>(
                    this@ImageActivity,
                    onLoading = {
                        stateProgress(true)
                    },
                    onSuccess = {
                        stateProgress(false)
                        it?.let {
                            setupView(it)
                        }
                    },
                    onFailure = {
                        stateProgress(false)
                    }
                )
                apiResultHandler.handleApiResult(response)
            }
        } catch (e: Exception) {
            e.stackTrace
        }
    }

    private fun setupView(dataRequestDTO: DataRequestDTO) {
        binding.recyclerview.adapter = ImageAdapter(this, dataRequestDTO.data)
    }

    private fun stateProgress(enabled: Boolean) {
        binding.loadingRequest.isIndeterminate = enabled
    }
}