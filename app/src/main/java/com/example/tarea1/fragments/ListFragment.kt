package com.example.tarea1.fragments

import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tarea1.R
import com.example.tarea1.databinding.FragmentListBinding
import com.example.tarea1.recycler.Anime
import com.example.tarea1.recycler.AnimeAdapter
import com.example.tarea1.viewmodels.ListViewModel


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var soundPool: SoundPool
    private var soundId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(5)
            .setAudioAttributes(audioAttributes)
            .build()

        soundId = soundPool.load(requireContext(), R.raw.click, 1)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity())[ListViewModel::class.java]

        binding.listRecyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = AnimeAdapter(requireContext(), soundPool, soundId) { anime ->
            viewModel.toggleFavourite(anime)
        }
        binding.listRecyclerView.adapter = adapter


        viewModel.animeList.observe(viewLifecycleOwner) { animes ->
            adapter.setItems(animes)
        }
    }

}