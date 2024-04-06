package com.example.animalsapp.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.animalsapp.R
import com.example.animalsapp.data.model.Animal
import com.example.animalsapp.databinding.AnimalCardBinding

class AnimalsListAdapter : RecyclerView.Adapter<AnimalsListAdapter.ViewHolder>() {
    private val items: ArrayList<Animal> = arrayListOf()

    inner class ViewHolder(
        private val binding: AnimalCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val context: Context = binding.root.context
        fun bind(animal: Animal) {
            with(binding) {
                animalName.text = animal.name
                animalScientificName.text =
                    context.getString(
                        R.string.animal_scientific_name,
                        animal.taxonomy.scientificName
                    )
                animalDiet.text =
                    context.getString(R.string.animal_diet, animal.characteristics.diet)
                animalHabitat.text =
                    context.getString(R.string.animal_habitat, animal.characteristics.habitat)
                animalLifeSpan.text =
                    context.getString(R.string.animal_life_span, animal.characteristics.lifespan)
            }
        }
    }

    fun setItems(animals: List<Animal>?) {
        val newItems = animals ?: arrayListOf()

        val diffResult = DiffUtil.calculateDiff(AnimalsListDiffUtil(items, newItems))

        items.clear()
        items.addAll(newItems)

        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            AnimalCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}