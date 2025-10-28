package com.example.fai_technology.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.fai_technology.databinding.FragmentDogImageBinding
import com.example.fai_technology.ui.viewmodel.EnergyViewModel
import com.squareup.picasso.Picasso

class DogImageFragment : Fragment() {

    private lateinit var binding: FragmentDogImageBinding
    private val viewModel: EnergyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentDogImageBinding.inflate(inflater, container, false)

        binding.btnGetDogImage.setOnClickListener {
            viewModel.loadRandomImage()
        }

        viewModel.dogImage.observe(viewLifecycleOwner) { dog ->
            dog?.let {
                Picasso.get()
                    .load(it.message)
                    .into(binding.imgDog)
            }
        }

        return binding.root
    }
}
