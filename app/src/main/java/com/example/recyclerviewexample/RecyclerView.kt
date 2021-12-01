package com.example.recyclerviewexample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.utils.Utils
import org.json.JSONException
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class RecyclerView : Fragment() {

    val TAG = "Fragment RecyclerView"

    var cityNames: ArrayList<String> = ArrayList()
    var cityContact: ArrayList<String> = ArrayList()
    var cityDescription: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "On Create")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d(TAG, "On Create View")
        return inflater.inflate(R.layout.fragment_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "On Created View")

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        val linearLayoutManager = LinearLayoutManager(view.context)

        recyclerView.layoutManager = linearLayoutManager
        try {
            val obj = JSONObject(Utils(this).loadJsonFromAssets(view.context, "places.json"))
            Log.d(TAG, "$obj")
            val placesArray = obj.getJSONArray("places")
            for (i in 0 until placesArray.length()) {
                val cityInfo = placesArray.getJSONObject(i)
                cityNames.add(cityInfo.getString("name"))
                cityContact.add(cityInfo.getString("contactInfo"))
                cityDescription.add(cityInfo.getString("description"))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        Log.d(TAG, "$cityNames")
        Log.d(TAG, "$cityContact")
        Log.d(TAG, "$cityDescription")

        val customAdapter = CustomAdapter(this, cityNames, cityContact, cityDescription)
        recyclerView.adapter = customAdapter
    }

}