package com.amarinag.dadu_fragments.dog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amarinag.dadu_fragments.databinding.ItemDogBinding

class DogAdapter(private val onAnimalClick: (Dog) -> Unit) :
    ListAdapter<Dog, DogAdapter.DogViewHolder>(DogDiffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDogBinding.inflate(inflater, parent, false)
        return DogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val animal = getItem(position)
        holder.binding.tvAnimalName.text = animal.name
        holder.binding.tvBreed.text = animal.breedName
        holder.itemView.setOnClickListener { onAnimalClick(animal) }
    }

    inner class DogViewHolder(val binding: ItemDogBinding) : RecyclerView.ViewHolder(binding.root)
}

object DogDiffUtils : DiffUtil.ItemCallback<Dog>() {
    override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean = oldItem == newItem
}