package com.example.spsapps.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spsapps.Data.API.PhotoApiClient
import com.example.spsapps.Home.Photo.PhotoAdapter
import com.example.spsapps.Home.pertemuan_10.TenthActivity
import com.example.spsapps.Home.pertemuan_13.ThirteenthActivity
import com.example.spsapps.databinding.FragmentHomeBinding
import com.example.spsapps.Home.pertemuan_3.ThirdActivity
import com.example.spsapps.Home.pertemuan_4.FourthActivity
import com.example.spsapps.Home.pertemuan_5.FifthActivity
import com.example.spsapps.Home.pertemuan_6.SixthActivity
import com.example.spsapps.Home.pertemuan_7.SeventhActivity
import com.example.spsapps.Home.pertemuan_9.NinthActivity
// TODO: Import Activity Pertemuan 13 Anda di sini, contoh:
// import com.example.spsapps.Home.pertemuan_13.ThirteenthActivity
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }
        super.onViewCreated(view, savedInstanceState)

        binding.btnPertemuan2.setOnClickListener {
            // Uncomment jika SecondActivity tersedia
            // startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        binding.btnPertemuan3.setOnClickListener {
            startActivity(Intent(requireContext(), ThirdActivity::class.java))
        }

        binding.btnPertemuan4.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java).apply {
                putExtra("name", "Syabil")
                putExtra("from", "Rumbai")
                putExtra("age", 30)
            }
            startActivity(intent)
        }

        binding.btnPertemuan5.setOnClickListener {
            startActivity(Intent(requireContext(), FifthActivity::class.java))
        }

        binding.btnPertemuan6.setOnClickListener {
            startActivity(Intent(requireContext(), SixthActivity::class.java))
        }

        binding.btnPertemuan7.setOnClickListener {
            startActivity(Intent(requireContext(), SeventhActivity::class.java))
        }

        binding.btnPertemuan9.setOnClickListener {
            startActivity(Intent(requireContext(), NinthActivity::class.java))
        }

        binding.btnPertemuan10.setOnClickListener {
            startActivity(Intent(requireContext(), TenthActivity::class.java))
        }

        // TAMBAHAN: Click Listener untuk Pertemuan 13
        binding.btnPertemuan13.setOnClickListener {
            startActivity(Intent(requireContext(), ThirteenthActivity::class.java))
        }

        loadPhoto()
    }

    private fun loadPhoto() {
        lifecycleScope.launch {
            try {
                val photos = PhotoApiClient.apiService.getPhotos()
                val adapter = PhotoAdapter(photos)
                binding.rvGallery.adapter = adapter

                /** List Tampil Vertical*/
//                binding.rvGallery.layoutManager = LinearLayoutManager(requireContext())

                /** List Tampil Horizontal */
                //binding.rvGallery.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

                /** List Tampil Grid */
                binding.rvGallery.layoutManager = GridLayoutManager(requireContext(), 2)

            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Gagal memuat gambar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}