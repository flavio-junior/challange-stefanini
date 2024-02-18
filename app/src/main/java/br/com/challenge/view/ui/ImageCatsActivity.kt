package br.com.challenge.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.challenge.data.dto.ImageCatsRequestDTO
import br.com.challenge.databinding.ActImagesCatsBinding
import br.com.challenge.utils.ApiResultHandler
import br.com.challenge.view.adapter.ImageCatsAdapter
import br.com.challenge.view.viewModel.ImageCatsViewModel
import org.koin.android.ext.android.inject

class ImageCatsActivity : AppCompatActivity() {

    private lateinit var binding: ActImagesCatsBinding
    private val viewModel: ImageCatsViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActImagesCatsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getImagesCats()
        observeRequest()
    }

    private fun getImagesCats() {
        viewModel.getImagesCats()
    }

    private fun observeRequest() {
        try {
            viewModel.responseImagesCats.observe(this@ImageCatsActivity) { response ->
                val apiResultHandler = ApiResultHandler<ImageCatsRequestDTO>(
                    this@ImageCatsActivity,
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

    private fun setupView(imageCatsRequestDTO: ImageCatsRequestDTO) {
        binding.recyclerview.adapter = ImageCatsAdapter(this, imageCatsRequestDTO.data)
    }

    private fun stateProgress(enabled: Boolean) {
        binding.loadingRequest.isIndeterminate = enabled
    }
}