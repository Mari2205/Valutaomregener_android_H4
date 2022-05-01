package dk.hovdeforlob4.valutaomregener_android_h4

import android.app.Activity
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import org.json.JSONTokener

class FixerCurrency {
    var context: Activity? = null
    constructor(context: Activity){
        this.context = context

        //fatchExchangeRates()
    }

    val apiUrl = "http://data.fixer.io/api/latest?access_key=7534e85c949fefdbe14a2d2a9f66797b"
    fun fatchExchangeRates(): String{
        var data = "defult"

        val queue = Volley.newRequestQueue(context)
        val reques = StringRequest(Request.Method.GET,apiUrl,
            Response.Listener { response ->

                Log.d("res", "Response : ${response.toString()}")
                data = response.toString()
                Log.d("data", data)

            }, Response.ErrorListener { error -> Log.d("res","That didn't work! | $error") })
        queue.add(reques)


        Log.d("res", "methoed ends")
        return data
    }

}