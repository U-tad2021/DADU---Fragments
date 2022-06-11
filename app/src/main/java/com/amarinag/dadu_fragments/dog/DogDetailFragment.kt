package com.amarinag.dadu_fragments.dog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.amarinag.dadu_fragments.databinding.FragmentDogDetailBinding
import com.amarinag.dadu_fragments.network.DogService
import com.amarinag.dadu_fragments.network.RemoteDog
import com.amarinag.dadu_fragments.network.toDomain
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://serveranimalutad-env.eba-zr9dsz3t.eu-west-3.elasticbeanstalk.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val dogService: DogService = retrofit.create(DogService::class.java)

        dogService.getAnimalById(animalId).enqueue(object : Callback<RemoteDog> {
            override fun onResponse(
                call: Call<RemoteDog>,
                response: Response<RemoteDog>
            ) {
                if (response.isSuccessful) {
                    response.body()?.toDomain()?.let {
                        populateData(it)
                    } ?: showError("Parse error")
                } else {
                    showError("Error Response")
                }
            }

            override fun onFailure(call: Call<RemoteDog>, t: Throwable) {
                showError(t.localizedMessage)
            }

        })
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