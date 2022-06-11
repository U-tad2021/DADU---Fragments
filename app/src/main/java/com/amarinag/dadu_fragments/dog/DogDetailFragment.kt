package com.amarinag.dadu_fragments.dog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.amarinag.dadu_fragments.R
import com.amarinag.dadu_fragments.databinding.FragmentDogDetailBinding

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
        val tvDogDetail: TextView = view.findViewById(R.id.tv_dog_detail)
        tvDogDetail.text = args.dogId

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}