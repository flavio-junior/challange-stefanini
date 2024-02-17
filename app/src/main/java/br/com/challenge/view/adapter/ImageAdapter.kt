package br.com.challenge.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.challenge.data.dto.ImageRequestDTO
import br.com.challenge.databinding.ItemImageBinding
import com.squareup.picasso.Picasso

class ImageAdapter(
    private val imageRequestDTOS: List<ImageRequestDTO> = mutableListOf()
) : RecyclerView.Adapter<ImageItemHolder>() {

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
        holder.bind(imageRequest)
    }

    override fun getItemCount(): Int = imageRequestDTOS.size
}

class ImageItemHolder(private val item: ItemImageBinding) : RecyclerView.ViewHolder(item.root) {

    fun bind(image: ImageRequestDTO) {
        Picasso.get().load(image.link).into(item.image)
    }
}