package com.amarinag.dadu_fragments.dog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.amarinag.dadu_fragments.databinding.FragmentDogListBinding
import com.google.android.material.snackbar.Snackbar

class DogListFragment : Fragment() {
    private var _binding: FragmentDogListBinding? = null
    private val binding
        get() = _binding!!

    private val adapter = DogAdapter {
        navigateToDetailNavController(it.id)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDogListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvAnimals.adapter = adapter
        binding.rvAnimals.layoutManager = LinearLayoutManager(context)
    }


    private fun doRequest(animalId: String) {
        // TODO: Make internet call here
    }

    private fun populateData(dogs: List<Dog>) {
        adapter.submitList(dogs)
    }

    private fun showError(message: String) {
        Snackbar.make(binding.rvAnimals, message, Snackbar.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // With Navigation Component + safeargs
    private fun navigateToDetailNavController(animalId: String) {
        val navController = findNavController()
        val action = DogListFragmentDirections.actionDogListFragmentToDogDetailFragment(animalId)
        navController.navigate(action)
    }
}