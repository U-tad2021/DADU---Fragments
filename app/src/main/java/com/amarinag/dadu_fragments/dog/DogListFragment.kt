package com.amarinag.dadu_fragments.dog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.amarinag.dadu_fragments.databinding.FragmentDogListBinding
import com.amarinag.dadu_fragments.network.DogService
import com.amarinag.dadu_fragments.network.RemoteDog
import com.amarinag.dadu_fragments.network.toDomain
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
        doRequest()
    }


    private fun doRequest() {
        // TODO: Make internet call here
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://serveranimalutad-env.eba-zr9dsz3t.eu-west-3.elasticbeanstalk.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val dogService: DogService = retrofit.create(DogService::class.java)

        dogService.getAnimals().enqueue(object : Callback<List<RemoteDog>> {
            override fun onResponse(
                call: Call<List<RemoteDog>>,
                response: Response<List<RemoteDog>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.map { it.toDomain() }?.let { populateData(it) }
                        ?: showError("Parse error")
                } else {
                    showError("Error Response")
                }
            }

            override fun onFailure(call: Call<List<RemoteDog>>, t: Throwable) {
                showError(t.localizedMessage)
            }

        })
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