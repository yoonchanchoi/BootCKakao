package com.example.bootckakao.presentation.search.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bootckakao.R
import com.example.bootckakao.databinding.ItemBookMarkBinding
import com.example.bootckakao.domain.search.model.ImageDocumentEntity

class BookMarkViewHolder(
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_book_mark, parent, false)
) {

    private val binding = ItemBookMarkBinding.bind(itemView)

    fun bind(
        imageDocumentEntity: ImageDocumentEntity,
        bookMarkClickListener: BookMarkClickListener
    ) {

        Glide.with(itemView.context)
            .load(imageDocumentEntity.thumbnailUrl)
            .fitCenter()
            .into(binding.ivImg)
        binding.tvTitle.text = imageDocumentEntity.displaySitename
        binding.tvDate.text = imageDocumentEntity.datetime
        binding.bookMarkItem.setOnLongClickListener {
            bookMarkClickListener.onItemLongeClick(adapterPosition, imageDocumentEntity)
        }
    }
}
