package com.example.tarea1.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea1.R
import com.example.tarea1.databinding.ItemLayoutBinding
import com.example.tarea1.viewmodels.ListViewModel

class AnimeAdapter(val context: Context,
                   private val onFavouriteClick: ((Anime) -> Unit)? = null): RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {
    private var items: List<Anime> = emptyList()

    fun setItems(newItems: List<Anime>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return AnimeViewHolder(binding)
    }
    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(items[position], onFavouriteClick)
    }
    override fun getItemCount(): Int {
        return items.size
    }


    class AnimeViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Anime, onFavouriteClick: ((Anime) -> Unit)? = null){
            binding.title.text = item.title
            binding.description.text = item.description
            binding.fav.setImageResource(
                if (item.favourite) R.drawable.ic_favourite else R.drawable.ic_no_favourite
            )

            binding.fav.setOnClickListener {
                onFavouriteClick?.invoke(item)
            }
        }
    }
}