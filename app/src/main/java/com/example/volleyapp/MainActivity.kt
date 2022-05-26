package com.example.volleyapp

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.stream.JsonReader
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ActivityCompat.requestPermissions(this,
            arrayOf<String>(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION), 1)
        val queue = Volley.newRequestQueue(this)
        val url = "http://api.weatherapi.com/v1/forecast.json?key=4b97fba8bdb44c2498e145727222405&q=madrid&days=1&aqi=yes&alerts=yes"
        /*val stringRequest = StringRequest(url,
        Response.Listener<String>{ response ->
            Log.i("TAG", "Respuesta:"+response.substring(1,100))
        },
            Response.ErrorListener { error -> error.printStackTrace() }
        )
        queue.add(stringRequest)*/
          val jsonIbjectRequest = JsonObjectRequest(url,null,
          Response.Listener{

              response->Log.i("Respuesta json", response.toString()   )
              Log.i("Respuesta json", response["location"].toString()   )
              val obj: ExampleJsonWeather? = Gson().fromJson(response.toString(),ExampleJsonWeather::class.java)
              Log.i("Respuesta json2", obj?.location?.name.toString())
          },
          Response.ErrorListener { error -> error.printStackTrace() })
          queue.add(jsonIbjectRequest)
         /* val jsonArrayRequest = JsonArrayRequest(Request.Method.GET,url,null,
              Response.Listener{
                      response->Log.i("Respuesta json", response[0].toString())
                  //Log.i("Respuesta json2", JSONObject.quote(response.toString()))
                  val obj: ExampleJsonWeather? = Gson().fromJson(response.toString(),ExampleJsonWeather::class.java)
                  Log.i("Respuesta json2", obj?.location?.name.toString())
              },
              Response.ErrorListener { error -> error.printStackTrace() })
          queue.add(jsonArrayRequest)*/
    }
}

private operator fun Any.get(s: String) {
}
