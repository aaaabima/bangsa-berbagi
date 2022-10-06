package com.aaaabima.bangsaberbagi.ui.informasi.dampak

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aaaabima.bangsaberbagi.R
import com.aaaabima.bangsaberbagi.databinding.FragmentAspekLingkunganBinding

class AspekLingkunganFragment : Fragment() {
    private lateinit var binding: FragmentAspekLingkunganBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentAspekLingkunganBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_aspek_lingkungan, container, false)
    }
}