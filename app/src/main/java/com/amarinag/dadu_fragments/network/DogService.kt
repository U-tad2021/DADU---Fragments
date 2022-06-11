package com.amarinag.dadu_fragments.network

import com.amarinag.dadu_fragments.dog.Dog
import retrofit2.Call
import retrofit2.http.GET

interface DogService {
    @GET("animals")
    fun getAnimals(): Call<List<RemoteDog>>
}

data class RemoteDog(
    val id: String,
    val name: String,
    val description: String,
    val age: Int,
    val imageUrl: String?
)

fun RemoteDog.toDomain(): Dog = Dog(id, name, description, name, age, imageUrl)