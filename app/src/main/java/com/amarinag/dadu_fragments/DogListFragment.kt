package com.amarinag.dadu_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class DogListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dog_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val clickMe: TextView = view.findViewById(R.id.tv_dog_list)

        clickMe.setOnClickListener { navigateToDetail("8724da83d9b14db8b027b33f6de75c8e") }
    }


    private fun navigateToDetail(dogId: String) {
        val fragmentManager: FragmentManager = parentFragmentManager
        val fragment = DogDetailFragment()
        val args = Bundle()
        args.putString("dogId", dogId)
        fragment.arguments = args
        fragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack("dog")
            .commit()
    }
}