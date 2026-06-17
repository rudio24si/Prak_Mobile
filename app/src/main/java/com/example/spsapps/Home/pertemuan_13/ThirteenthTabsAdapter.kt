package com.example.spsapps.Home.pertemuan_13

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.spsapps.Home.pertemuan_10.TabAFragment
import com.example.spsapps.Home.pertemuan_10.TabBFragment
import com.example.spsapps.Home.pertemuan_10.TabCFragment
import com.example.spsapps.R

class ThirteenthTabsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    // Jumlah total tab yang ada
    override fun getItemCount(): Int = 3

    // Menentukan Fragment mana yang akan ditampilkan berdasarkan posisi tab
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabCaptureFragment()
            1 -> TabQrcodeFragment()
            2 -> TabScanFragment()
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}