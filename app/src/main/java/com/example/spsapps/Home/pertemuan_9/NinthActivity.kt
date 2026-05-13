package com.example.spsapps.Home.pertemuan_9

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.spsapps.R
import com.example.spsapps.databinding.ActivityNinthBinding
import com.example.spsapps.databinding.ActivitySeventhBinding
import com.google.android.material.chip.Chip

class NinthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNinthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNinthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
//        setContentView(R.layout.activity_ninth)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar4)
        supportActionBar?.apply {
//            title = "Activity Fifth"
//            subtitle = "Ini adalah subtitle"
            setDisplayHomeAsUpEnabled(true)
//            setDisplayShowHomeEnabled(true)
//            onBackPressedDispatcher.onBackPressed()
        }

        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull() // Ambil ID chip yang dipilih
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                Toast.makeText(this, "Filter: ${chip.text}", Toast.LENGTH_SHORT).show()
                // Lakukan logika filter di sini
            }
        }
    }
}