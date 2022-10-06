package com.aaaabima.bangsaberbagi.ui.informasi.pengenalan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aaaabima.bangsaberbagi.R
import com.aaaabima.bangsaberbagi.databinding.FragmentPemilahanSampahBinding

class PemilahanSampahFragment : Fragment() {
    private lateinit var binding: FragmentPemilahanSampahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPemilahanSampahBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_pemilahan_sampah, container, false)
    }
}