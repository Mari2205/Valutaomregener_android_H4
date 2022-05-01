package dk.hovdeforlob4.valutaomregener_android_h4

import android.app.Activity
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class FixerCurrency {
    var context: Activity? = null
    constructor(context: Activity){
        this.context = context

        fatchExchangeRates()
    }

//    val apiUrl_test = "https://jsonplaceholder.typicode.com/posts"
    val apiUrl = "http://data.fixer.io/api/latest?access_key=7534e85c949fefdbe14a2d2a9f66797b"
    fun fatchExchangeRates(){
        val queue = Volley.newRequestQueue(context)
        val reques = StringRequest(Request.Method.GET,apiUrl,
            Response.Listener { response ->

                Log.e("respones", "Response : ${response.toString()}")
                val data = response.toString()
                Log.d("data", data)

            }, Response.ErrorListener { error -> Log.d("respones","That didn't work! | $error") })
        queue.add(reques)
    }

    /**
     * @see_jsonPlaceholder https://jsonplaceholder.typicode.com/
     * @see_CurrencyAPI fixer.io: https://fixer.io/
     */
}