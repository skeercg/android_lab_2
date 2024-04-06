package com.example.animalsapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.animalsapp.data.model.Animal
import com.example.animalsapp.data.network.ApiClient
import com.example.animalsapp.databinding.AnimalsListFragmentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimalsListFragment : Fragment() {
    private val apiClient: ApiClient by lazy {
        ApiClient
    }

    private val adapter: AnimalsListAdapter by lazy {
        AnimalsListAdapter()
    }

    private var _binding: AnimalsListFragmentBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AnimalsListFragmentBinding.inflate(inflater, container, false)

        _binding?.searchButton?.setOnClickListener {
            searchAnimals(_binding?.editText?.text.toString())
        }

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        with(binding) {
            animalsList.adapter = adapter
        }
    }


    private fun searchAnimals(text: String) {
        apiClient.animalsApi.getAnimals(text).enqueue(object : Callback<List<Animal>> {
            override fun onResponse(call: Call<List<Animal>>, response: Response<List<Animal>>) {
                adapter.setItems(response.body())
                Log.d("API", "${response.body()}")
            }

            override fun onFailure(call: Call<List<Animal>>, t: Throwable) {
                Log.d("API_ERROR", "${t.message}")
            }
        })
    }
}