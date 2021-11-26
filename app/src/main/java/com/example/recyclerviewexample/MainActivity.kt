package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.utils.Utils
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
//    var cityNames: ArrayList<String> = ArrayList()
//    var cityContact: ArrayList<String> = ArrayList()
//    var cityDescription: ArrayList<String> = ArrayList()
    var isFrameOneLoaded : Boolean = true
    val manager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
//        val linearLayoutManager = LinearLayoutManager(applicationContext)
//
//        recyclerView.layoutManager = linearLayoutManager
//        try {
//            val obj = JSONObject(Utils(this).loadJsonFromAssets(applicationContext, "places.json"))
//            val placesArray = obj.getJSONArray("places")
//            for (i in 0 until placesArray.length()) {
//                val cityInfo = placesArray.getJSONObject(i)
//                cityNames.add(cityInfo.getString("name"))
//                cityContact.add(cityInfo.getString("contactInfo"))
//                cityDescription.add(cityInfo.getString("description"))
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//        val customAdapter = CustomAdapter(this@MainActivity, cityNames, cityContact, cityDescription)
//        recyclerView.adapter = customAdapter

//        val flowerList = Utils(this).getFlowersList()
//        recyclerView.adapter = FlowerAdapter(flowerList)
//        println(flowerList)

        val change  = findViewById<Button>(R.id.btn_change)
        ShowFragmentOne()
        change.setOnClickListener {
            if (isFrameOneLoaded) {
                ShowFragmentTwo()
            } else {
                ShowFragmentOne()
            }
        }
    }

    fun ShowFragmentOne () {
        val transaction = manager.beginTransaction()
        val fragment = FragmentOne()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFrameOneLoaded = true
    }

    fun ShowFragmentTwo () {
        val transaction = manager.beginTransaction()
        val fragment = FragmentTwo()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFrameOneLoaded = false
    }
}