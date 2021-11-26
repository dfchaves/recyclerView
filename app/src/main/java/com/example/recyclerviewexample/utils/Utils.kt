package com.example.recyclerviewexample.utils

import android.content.Context
import com.example.recyclerviewexample.R
import java.io.IOException
import java.nio.charset.Charset

class Utils (val context: Context){
    fun getFlowersList(): Array<String> {
        return context.resources.getStringArray(R.array.flower_array)
    }

    fun loadJsonFromAssets(context: Context, fileName: String): String {
        val json: String?
        try {
            val inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charset.defaultCharset()
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        } catch (ex: IOException){
            ex.printStackTrace()
            return ""
        }
        return json
    }
}