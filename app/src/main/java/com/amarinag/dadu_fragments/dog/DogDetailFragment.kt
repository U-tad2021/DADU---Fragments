package com.amarinag.dadu_fragments.dog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.amarinag.dadu_fragments.databinding.FragmentDogDetailBinding
import com.google.android.material.snackbar.Snackbar

class DogDetailFragment : Fragment() {
    private var _binding: FragmentDogDetailBinding? = null
    private val binding
        get() = _binding!!

    private val args: DogDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDogDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doRequest(args.dogId)
    }

    private fun doRequest(animalId: String) {
        // TODO: Make internet call here
    }

    private fun populateData(dog: Dog) {
        binding.tvAnimalName.text = dog.name
        binding.tvAnimalBreed.text = dog.breedName
        binding.tvAnimalAge.text = dog.age.toString()
        binding.ivAnimalAvatar.load(dog.imageUrl)
    }

    private fun showError(message: String) {
        Snackbar.make(binding.tvAnimalName, message, Snackbar.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}