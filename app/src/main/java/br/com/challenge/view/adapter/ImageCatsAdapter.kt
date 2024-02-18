package br.com.challenge.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import br.com.challenge.data.dto.DataRequestDTO
import br.com.challenge.databinding.ItemImageCatBinding
import com.bumptech.glide.Glide

class ImageCatsAdapter(
    private val context: Context,
    private val dataRequestDTOS: List<DataRequestDTO> = mutableListOf()
) : RecyclerView.Adapter<ImageCatsAdapter.ImageCatItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageCatItemHolder {
        val item = ItemImageCatBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ImageCatItemHolder(item)
    }

    override fun onBindViewHolder(holder: ImageCatItemHolder, position: Int) {
        val dataRequestDTO: DataRequestDTO = dataRequestDTOS[position]
        dataRequestDTO.images.forEach {
            when (it.type) {
                "image/jpeg" ->
                    Glide
                        .with(context)
                        .load(it.link)
                        .centerCrop()
                        .error({ holder.box.isVisible = false })
                        .into(holder.imageView)
            }
        }
    }

    override fun getItemCount(): Int = dataRequestDTOS.size

    class ImageCatItemHolder(private val item: ItemImageCatBinding) :
        RecyclerView.ViewHolder(item.root) {
        val box: ConstraintLayout = item.box
        val imageView: ImageView = item.image
    }
}