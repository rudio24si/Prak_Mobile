package com.example.spsapps

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.spsapps.databinding.ActivityMainBinding
import com.example.spsapps.databinding.ActivityThirdBinding
import com.example.spsapps.pertemuan_3.ThirdResultActivity
import com.example.spsapps.pertemuan_4.FourthActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import androidx.core.content.edit
import com.example.spsapps.pertemuan_6.SixthActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)

            intent.putExtra("name", "Syabil")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 30)

            startActivity(intent)
            finish()
        }
        binding.btnSixth.setOnClickListener {
            val intent = Intent(this, SixthActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLogout.setOnClickListener {
            val sharedPref = getSharedPreferences("session_user", MODE_PRIVATE)
            val intent = Intent(this, AuthActivity::class.java)
            MaterialAlertDialogBuilder(this)
                .setTitle("Logout")
                .setMessage("yakin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    sharedPref.edit {
                        clear()
                    }

                    dialog.dismiss()
                    startActivity(intent)
                    finish()
                }.show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: {nama_activity} terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "{nama_activity} dihapus dari stack")
    }
}