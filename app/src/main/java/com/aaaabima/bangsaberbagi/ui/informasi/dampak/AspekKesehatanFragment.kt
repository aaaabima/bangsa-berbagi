package com.aaaabima.bangsaberbagi.ui.informasi.dampak

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aaaabima.bangsaberbagi.R
import com.aaaabima.bangsaberbagi.databinding.FragmentAspekKesehatanBinding

class AspekKesehatanFragment : Fragment() {
    private lateinit var binding: FragmentAspekKesehatanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentAspekKesehatanBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_aspek_kesehatan, container, false)
    }
}