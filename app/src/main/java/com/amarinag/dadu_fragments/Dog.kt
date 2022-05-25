package com.amarinag.dadu_fragments

import android.os.Parcel
import android.os.Parcelable

data class Dog(
    val id: String,
    val name: String,
    val description: String,
    val age: Int,
    val imageUrl: String
)