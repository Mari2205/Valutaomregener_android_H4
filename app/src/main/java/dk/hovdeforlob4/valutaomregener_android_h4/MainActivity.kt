package dk.hovdeforlob4.valutaomregener_android_h4

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import dk.hovdeforlob4.valutaomregener_android_h4.databinding.ActivityMainBinding

//import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

//TODO: better names
//TODO: remove not used imports
//TODO: look how manny lines removed in this class
//TODO: marby make dev notes file
//TODO: use the currencyPresenter class
//TODO: Clean up / refactor
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide() // removes the actionbar
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        /**
         * @see_interface interfaces implementation: https://www.youtube.com/watch?v=5C7W98VVI88
         */
//        val mockData_temp = listOf<Rate>(Rate("DKK", 1.0))
        val mockDataObj = MockCurrency()
        val mockData = mockDataObj.getRates("")
//
//
//        Log.d("mock data", "mock data      : ${mockData[0]}")
//        Log.d("mock data", "mock data temp : ${mockData_temp[0].name}")
//
        var baseArr: Array<String> = getAllBaseCurrency(mockData)
        setSpinner(baseArr)
//        val arr = convertListToArray(mockData)
//        setListView(arr)
//        //binding.listview.adapter = ListViewAdapter(this, arr)
//        Log.d("list_view", "method run")

        ///////////////////////////////////////////////

//        val mockDataJson = mockDataObj.jsonRespose()
//        val j = JsonParser(mockDataJson)
//        j.convertToCurrencyModel()
//        jsonHolder(mockDataJson)
        //    val fixerCurrency = FixerCurrency(this)
        //    downloadTasks2()




//        val jparser = JsonParser(mockDataJson)
//        val calc = CurrencyCalculator()
//
//        val data = jparser.convertToCurrencyModel()
//
//        val spinner_wig = findViewById<Spinner>(R.id.spinner_base)
//        val usrBase: String = spinner_wig.getSelectedItem().toString()
//        val value = calc.calcultRates(usrBase, data.rates)
//        val baseRate = value.first
//        val usrRate = value.second
//        val completValue = calc.calcultValue(baseRate,usrRate,100.00, data.rates)//TODO: make overload



    }

//    val apiUrl = "https://jsonplaceholder.typicode.com/posts"
//    fun downloadTasks() {
//        Log.d("respones", "method start")
//
//        val queue = Volley.newRequestQueue(this)
//
//        val reques = StringRequest(Request.Method.GET, apiUrl,
//            Response.Listener { response ->
//
//                Log.d("respones", "Response : ${response.toString()}")
//
//            }, Response.ErrorListener { Log.d("respones", "that din´t work!") })
//        queue.add(reques)
//    }
//    /**
//     * @see_volley https://google.github.io/volley/simple.html
//     */
//    fun downloadTasks2() {
//
//        StrictMode.setThreadPolicy(
//            StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build()
//        )
//        // Instantiate the RequestQueue.
//        val queue = Volley.newRequestQueue(this)
//        val url = "https://jsonplaceholder.typicode.com/posts"
//
//// Request a string response from the provided URL.
//        val stringRequest = StringRequest(Request.Method.GET, url,
//            Response.Listener<String> { response ->
//                // Display the first 500 characters of the response string.
//                Log.d("respones", "Response is: ${response.substring(0, 500)}")
//            },
//            Response.ErrorListener { error -> Log.d("respones", "That didn't work! | $error") })
//
//// Add the request to the RequestQueue.
//        queue.add(stringRequest)
//    }


//    fun jsonHolder(data: String) {
//        val gson = Gson()
//        var test:CurrencyModel = gson.fromJson(data,CurrencyModel::class.java)
//        println("from json string: " + test)
////        val mapper = jacksonObjectMapper()
////        val jData: List<CurrencyModel> = mapper.readValue(data)
//
//        val j = JSONObject(data)
////        val js = gson.fromJson(j, Rate::class.java)
//        val jArray = JSONArray(data)
//
//        for (item in 0..jArray.length() - 1) {
//            var jObj = jArray.getJSONObject(item)
//            var userId = jObj.getInt("userId")
//            var id = jObj.getInt("id")
//            var title = jObj.getString("title")
//            var body = jObj.getString("body")
//            Log.d(
//                "jsonobj", "\n" +
//                        "userId : ${userId.toString()}\n" +
//                        "id     : ${id.toString()}\n" +
//                        "title  : ${title.toString()}\n" +
//                        "body   : ${body.toString()}\n" +
//                        "------------------------"
//            )
////            Log.e("respones", "userId : ${userId.toString()}")
////            Log.e("respones", "id     : ${id.toString()}")
////            Log.e("respones", "title  : ${title.toString()}")
////            Log.e("respones", "body   : ${body.toString()}")
////            Log.e("respones", "-----------------------------------")
//
//        }
//    }

    fun calcBtn(view: View){
        val textbox = findViewById<EditText>(R.id.editText_valuta)

        val mockDataObj = MockCurrency()
        val mockDataJson = mockDataObj.jsonRespose()
        val jparser = JsonParser(mockDataJson)
        val calc = CurrencyCalculator()

        val data = jparser.convertToCurrencyModel()

        val spinner_wig = findViewById<Spinner>(R.id.spinner_base)
        val usrBase: String = spinner_wig.getSelectedItem().toString()
//        val value = calc.calculateRates(usrBase, data.rates)
//        val baseRate = value.first
//        val usrRate = value.second
        val input_value = textbox.text.toString().toDouble()
//        val completValue = calc.calculateValue(usrBase, usrRate, input_value, data.rates)//TODO: make overload

        val currencyPresenter = CurrencyPresenter()
        val completValueLst = currencyPresenter.ConvertCurrency(usrBase, input_value, data.rates)

        val arr = convertListToArray(completValueLst)
        setListView(arr)
    }


    fun getSpinnerSelectedValue(view: View) {
        val textbox = findViewById<EditText>(R.id.editText_valuta)
        val spinner_wig = findViewById<Spinner>(R.id.spinner_base)
        val text: String = spinner_wig.getSelectedItem().toString()

        textbox.setText("selected : $text")
    }


    /**
     * this method takes an list of Rates og sorter all currency bases into an array of string
     * @see_loops Doc for kotlin Loops : https://kotlinlang.org/docs/control-flow.html#for-loops
     */
    fun getAllBaseCurrency(rateLst: List<Rate>): Array<String> {

        val currencyBaseArrLst: MutableList<String> = ArrayList()

        for (item in rateLst) {
            currencyBaseArrLst.add(item.name)
        }

        return currencyBaseArrLst.toTypedArray()
    }


    /**
     * this method sets array of currency base to the spinner(dropdown box)
     * @see_spinner Example code on spinner : https://www.tutorialkart.com/kotlin-android/android-spinner-kotlin-example/
     */
    fun setSpinner(baseArr: Array<String>) {
        val spinnerLst = findViewById<Spinner>(R.id.spinner_base)
        // TODO: look into adapter
        // Create an ArrayAdapter using a simple spinner layout and languages array
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, baseArr)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinnerLst!!.setAdapter(aa)
    }


    /**
     * this method sets listview wiget with a custom layout with cuency rates (rate(DKK) and values(1.553))
     */
    fun setListView(ratesLst: ArrayList<Rate>) {
        Log.d("list_view", "inside methode")
        binding.listview.adapter = ListViewAdapter(this, ratesLst)
//rm      val listView_rates = findViewById<ListView>(R.id.listview_)
//rm      val arrayAdapter: ArrayAdapter<String> =
//rm           ArrayAdapter<String>(this,  listView_rates, ratesLst)

//rm      val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ratesLst)
//rm      listView_rates.adapter = adapter
//rm      listView_rates.setAdapter(adapter)
    }


    //TODO: maybe remove later on
    fun convertListToArray(ratesLst: List<Rate>): ArrayList<Rate> {
        val output = mutableListOf<Rate>()

        for (item in ratesLst) {
            output.add(Rate(item.name, item.spotRate))
        }
        return output.toTypedArray().toCollection(ArrayList())
    }
}