package com.amarinag.dadu_fragments.network

import com.amarinag.dadu_fragments.dog.Dog
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DogService {
    @GET("animals")
    fun getAnimals(): Call<List<RemoteDog>>

    @GET("animals/{animalId}")
    fun getAnimalById(@Path("animalId") animalId: String): Call<RemoteDog>
}

data class RemoteDog(
    val id: String,
    val name: String,
    val description: String,
    val breed: Breed,
    val age: Int,
    val imageUrl: String?
)

data class Breed(
    val id: String,
    val name: String,
    val description: String

)

fun RemoteDog.toDomain(): Dog = Dog(id, name, description, breed.name, age, imageUrl)