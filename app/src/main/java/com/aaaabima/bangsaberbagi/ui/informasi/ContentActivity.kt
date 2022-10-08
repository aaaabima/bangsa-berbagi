package com.aaaabima.bangsaberbagi.ui.informasi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aaaabima.bangsaberbagi.R
import com.aaaabima.bangsaberbagi.databinding.ActivityContentBinding
import com.aaaabima.bangsaberbagi.ui.informasi.dampak.AspekEkonomiFragment
import com.aaaabima.bangsaberbagi.ui.informasi.dampak.AspekKesehatanFragment
import com.aaaabima.bangsaberbagi.ui.informasi.dampak.AspekLingkunganFragment
import com.aaaabima.bangsaberbagi.ui.informasi.pemanfaatan.KegunaanPupukFragment
import com.aaaabima.bangsaberbagi.ui.informasi.pemanfaatan.KreativitasSampahFragment
import com.aaaabima.bangsaberbagi.ui.informasi.pemanfaatan.MembuatPupukFragment
import com.aaaabima.bangsaberbagi.ui.informasi.pemanfaatan.NilaiEkonomiSampahFragment
import com.aaaabima.bangsaberbagi.ui.informasi.pengenalan.JenisSampahFragment
import com.aaaabima.bangsaberbagi.ui.informasi.pengenalan.ManfaatSampahFragment
import com.aaaabima.bangsaberbagi.ui.informasi.pengenalan.PemilahanSampahFragment
import com.aaaabima.bangsaberbagi.ui.informasi.pengenalan.PengolahanSampahFragment

class ContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentName = intent.getStringExtra(EXTRA_FRAGMENT)

        supportActionBar?.title = fragmentName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        addFragment(fragmentName)
    }

    private fun addFragment(name: String?) {
        val mFragmentManager = supportFragmentManager
        when (name) {
             "Jenis Jenis Sampah" -> {
                val mJenisSampahFragment = JenisSampahFragment()
                mFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_layout, mJenisSampahFragment, JenisSampahFragment::class.java.simpleName)
                    .commit()
            }
            "Manfaat Sampah" -> {
                val mManfaatSampahFragment = ManfaatSampahFragment()
                mFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_layout, mManfaatSampahFragment, ManfaatSampahFragment::class.java.simpleName)
                    .commit()
            }
            "Pengolahan Sampah" -> {
                val mPengolahanSampahFragment = PengolahanSampahFragment()
                mFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_layout, mPengolahanSampahFragment, PengolahanSampahFragment::class.java.simpleName)
                    .commit()
            }
            "Pemilahan Sampah" -> {
                val mPemilahanSampahFragment = PemilahanSampahFragment()
                mFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_layout, mPemilahanSampahFragment, PemilahanSampahFragment::class.java.simpleName)
                    .commit()
            }
            "Aspek Lingkungan" -> {
                val mAspekLingkunganFragment = AspekLingkunganFragment()
                mFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_layout, mAspekLingkunganFragment, AspekLingkunganFragment::class.java.simpleName)
                    .commit()
            }
            "Aspek Kesehatan" -> {
                val mAspekKesehatanFragment = AspekKesehatanFragment()
                mFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_layout, mAspekKesehatanFragment, AspekKesehatanFragment::class.java.simpleName)
                    .commit()
            }
            "Aspek Ekonomi" -> {
                val mAspekEkonomiFragment = AspekEkonomiFragment()
                mFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_layout, mAspekEkonomiFragment, AspekEkonomiFragment::class.java.simpleName)
                    .commit()
            }
            "Kegunaan Pupuk" -> {
                val mKegunaanPupukFragment = KegunaanPupukFragment()
                mFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_layout, mKegunaanPupukFragment, KegunaanPupukFragment::class.java.simpleName)
                    .commit()
            }
            "Kreativitas Sampah" -> {
                val mKreativitasSampahFragment = KreativitasSampahFragment()
                mFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_layout, mKreativitasSampahFragment, KreativitasSampahFragment::class.java.simpleName)
                    .commit()
            }
            "Membuat Pupuk" -> {
                val mMembuatPupukFragment = MembuatPupukFragment()
                mFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_layout, mMembuatPupukFragment, MembuatPupukFragment::class.java.simpleName)
                    .commit()
            }
            "Nilai Ekonomi Sampah" -> {
                val mNilaiEkonomiSampahFragment = NilaiEkonomiSampahFragment()
                mFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_layout, mNilaiEkonomiSampahFragment, NilaiEkonomiSampahFragment::class.java.simpleName)
                    .commit()
            }
        }
    }

    companion object {
        const val EXTRA_FRAGMENT = "extra_fragment"
    }
}