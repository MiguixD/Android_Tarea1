package com.example.tarea1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tarea1.R
import com.example.tarea1.databinding.FragmentFavBinding
import com.example.tarea1.databinding.FragmentListBinding
import com.example.tarea1.recycler.Anime
import com.example.tarea1.recycler.AnimeAdapter
import com.example.tarea1.viewmodels.ListViewModel


class FavFragment : Fragment() {
    private lateinit var binding: FragmentFavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity())[ListViewModel::class.java]

        binding.favRecyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = AnimeAdapter(requireContext(), onFavouriteClick = null)

        binding.favRecyclerView.adapter = adapter


        viewModel.animeFavouriteList.observe(viewLifecycleOwner) { favourites ->
            adapter.setItems(favourites)
        }
    }
}