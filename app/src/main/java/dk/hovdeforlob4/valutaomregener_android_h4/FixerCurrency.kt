package dk.hovdeforlob4.valutaomregener_android_h4

import android.app.Activity
import android.app.DownloadManager
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class FixerCurrency {
    var context: Activity? = null
    constructor(context: Activity){
        this.context = context

        downloadTasks()
    }

//    val apiUrl_test = "https://jsonplaceholder.typicode.com/posts"
    val apiUrl = "http://data.fixer.io/api/latest?access_key=7534e85c949fefdbe14a2d2a9f66797b"
    fun downloadTasks(){
        val queue = Volley.newRequestQueue(context)
        val reques = StringRequest(Request.Method.GET,apiUrl,
            Response.Listener { response ->

                Log.e("respones", "Response : ${response.toString()}")
                val data = response.toString()
                Log.d("data", data)
                val t = ""

            }, Response.ErrorListener { error -> Log.d("respones","That didn't work! | $error") })
        queue.add(reques)
    }

//    fun jsonHolder(data:String){
//        val jArray = JSONArray(data)
//
//        for (item in 0..jArray.length()-1){
//            var jObj = jArray.getJSONObject(item)
//            var userId = jObj.getInt("userId")
//            var id = jObj.getInt("id")
//            var title = jObj.getString("title")
//            var body = jObj.getString("body")
//            Log.e("respones", "userId : ${userId.toString()}")
//            Log.e("respones", "id     : ${id.toString()}")
//            Log.e("respones", "title  : ${title.toString()}")
//            Log.e("respones", "body   : ${body.toString()}")
//            Log.e("respones", "-----------------------------------")
//
//        }
//
//    }

    /**
     * @see_jsonPlaceholder https://jsonplaceholder.typicode.com/
     * @see_CurrencyAPI fixer.io: https://fixer.io/
     */
}