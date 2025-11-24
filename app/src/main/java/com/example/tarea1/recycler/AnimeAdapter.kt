package com.example.tarea1.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea1.R
import com.example.tarea1.databinding.ItemLayoutBinding

class AnimeAdapter(val context: Context, val items:List<Anime>): RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return AnimeViewHolder(binding)
    }
    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(items[position])
    }
    override fun getItemCount(): Int {
        return items.size
    }

    class AnimeViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Anime){
            binding.title.text = item.title
            binding.description.text = item.description

            if(item.favourite)
                binding.fav.setImageResource(R.drawable.ic_favourite)
            else
                binding.fav.setImageResource(R.drawable.ic_no_favourite)

            binding.fav.setOnClickListener {
                if(item.favourite)
                    binding.fav.setImageResource(R.drawable.ic_no_favourite)
                else
                    binding.fav.setImageResource(R.drawable.ic_favourite)

                item.favourite = !item.favourite
            }
        }
    }
}