package com.example.bootckakao.presentation.search.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bootckakao.R
import com.example.bootckakao.databinding.ItemSearchBinding
import com.example.bootckakao.domain.search.model.ImageDocument

class SearchViewHolder(
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
) {

    private val binding = ItemSearchBinding.bind(itemView)

    fun bind(
        imageDocumentEntity: ImageDocument,
        searchFavoriteClickListener: SearchFavoriteClickListener
    ) {

        Glide.with(itemView.context)
            .load(imageDocumentEntity.thumbnailUrl)
            .fitCenter()
            .into(binding.ivImg)
        binding.tvTitle.text = imageDocumentEntity.displaySitename
        binding.tvDate.text = imageDocumentEntity.datetime

        binding.acbFavorite.isChecked = imageDocumentEntity.favorite
        Log.e("cyc","adapterPosition-->${adapterPosition}")
        Log.e("cyc","imageDocumentEntity.favorite-->${imageDocumentEntity.favorite}")
        binding.acbFavorite.setOnClickListener {
            searchFavoriteClickListener.onFavoriteItemClick(
                adapterPosition,
                imageDocumentEntity
            )
        }
    }
}
