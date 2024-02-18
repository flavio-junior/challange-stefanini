package br.com.challenge.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.challenge.data.dto.ImageRequestDTO
import br.com.challenge.databinding.ItemImageBinding
import com.bumptech.glide.Glide

class ImageAdapter(
    private val context: Context,
    private val imageRequestDTOS: List<ImageRequestDTO> = mutableListOf()
) : RecyclerView.Adapter<ImageAdapter.ImageItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageItemHolder {
        val item = ItemImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ImageItemHolder(item)
    }

    override fun onBindViewHolder(holder: ImageItemHolder, position: Int) {
        val imageRequest: ImageRequestDTO = imageRequestDTOS[position]
        holder.bind(context, imageRequest)
    }

    override fun getItemCount(): Int = imageRequestDTOS.size

    class ImageItemHolder(private val item: ItemImageBinding) : RecyclerView.ViewHolder(item.root) {

        fun bind(context: Context, image: ImageRequestDTO) {
            image.images.forEach {
                when (it.type) {
                    "image/jpeg" -> Glide.with(context).load(it.link).fitCenter().into(item.image)
                }
            }
        }
    }
}