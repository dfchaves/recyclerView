package com.example.recyclerviewexample.utils

import android.content.Context
import com.example.recyclerviewexample.R

class Utils (val context: Context){
    fun getFlowersList(): Array<String> {
        return context.resources.getStringArray(R.array.flower_array)
    }
}