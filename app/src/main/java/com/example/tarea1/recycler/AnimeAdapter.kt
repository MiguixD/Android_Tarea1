package com.example.tarea1.recycler

import android.content.Context
import android.media.SoundPool
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea1.R
import com.example.tarea1.databinding.ItemLayoutBinding
import com.example.tarea1.viewmodels.ListViewModel

class AnimeAdapter(val context: Context,
                   private val soundPool: SoundPool,
                   private val soundId: Int,
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
        holder.bind(items[position], soundPool, soundId, onFavouriteClick)
    }
    override fun getItemCount(): Int {
        return items.size
    }


    class AnimeViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Anime, soundPool: SoundPool, soundId: Int, onFavouriteClick: ((Anime) -> Unit)? = null){
            binding.position.text = bindingAdapterPosition.toString()
            binding.title.text = item.title
            binding.description.text = item.description
            binding.imageView.setImageResource(item.image)
            binding.fav.setImageResource(
                if (item.favourite) R.drawable.ic_favourite else R.drawable.ic_no_favourite
            )

            binding.fav.setOnClickListener {
                if(onFavouriteClick != null) {
                    soundPool.play(
                        soundId,
                        1f,
                        1f,
                        0,
                        0,
                        1f
                    )
                }
                onFavouriteClick?.invoke(item)
            }
        }
    }
}