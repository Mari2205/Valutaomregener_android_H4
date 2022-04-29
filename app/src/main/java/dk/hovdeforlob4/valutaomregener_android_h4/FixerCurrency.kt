package dk.hovdeforlob4.valutaomregener_android_h4

import android.app.Activity
import android.app.DownloadManager
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class FixerCurrency/*(private val context: Activity)*/ {
    var context: Activity? = null
    constructor(context: Activity){
        this.context = context

        downloadTasks()
    }

    val apiUrl = "https://jsonplaceholder.typicode.com/posts"

    fun downloadTasks(){
        val queue = Volley.newRequestQueue(context)
        val reques = StringRequest(Request.Method.GET,apiUrl,
            Response.Listener { response ->

                Log.e("Err", "Response : ${response.toString()}")

            }, Response.ErrorListener {  })
        queue.add(reques)
        val t =""
    }

    /**
     * @see_jsonPlaceholder https://jsonplaceholder.typicode.com/
     * @see_CurrencyAPI fixer.io: https://fixer.io/
     */
}