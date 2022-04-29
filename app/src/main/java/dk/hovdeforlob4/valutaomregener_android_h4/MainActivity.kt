package dk.hovdeforlob4.valutaomregener_android_h4

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.createBitmap
import dk.hovdeforlob4.valutaomregener_android_h4.databinding.ActivityMainBinding


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
        val mockData_temp = listOf<Rate>(Rate("DKK", 1.0))
        val mockDataObj = MockCurrency()
        val mockData = mockDataObj.getRates("")


        Log.d("mock data", "mock data      : ${mockData[0]}")
        Log.d("mock data", "mock data temp : ${mockData_temp[0].name}")

        var baseArr:Array<String> = getAllBaseCurrency(mockData)
        setSpinner(baseArr)
        val arr = convertListToArray(mockData)
        setListView(arr)
        //binding.listview.adapter = ListViewAdapter(this, arr)
        Log.d("list_view", "method run")

    }

    fun getSpinnerSelectedValue(view:View){
        val textbox = findViewById<EditText>(R.id.editText_valuta)
        val spinner_wig = findViewById<Spinner>(R.id.spinner_base)
        val text: String = spinner_wig.getSelectedItem().toString()

        textbox.setText("selected : $text")
    }


    /**
     * this method takes an list of Rates og sorter all currency bases into an array of string
     * @see_loops Doc for kotlin Loops : https://kotlinlang.org/docs/control-flow.html#for-loops
     */
    fun getAllBaseCurrency(rateLst:List<Rate>):Array<String>{

        val currencyBaseArrLst: MutableList<String> = ArrayList()

        for (item in rateLst){
            currencyBaseArrLst.add(item.name)
        }

        return currencyBaseArrLst.toTypedArray()
    }


    /**
     * this method sets array of currency base to the spinner(dropdown box)
     * @see_spinner Example code on spinner : https://www.tutorialkart.com/kotlin-android/android-spinner-kotlin-example/
     */
    fun setSpinner(baseArr:Array<String>){
        val spinnerLst = findViewById<Spinner>(R.id.spinner_base)
        // TODO: look into adapter
        // Create an ArrayAdapter using a simple spinner layout and languages array
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, baseArr)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinnerLst!!.setAdapter(aa)
    }

    fun setListView(ratesLst:ArrayList<Rate>){
        Log.d("list_view", "inside methode")
        binding.listview.adapter = ListViewAdapter(this, ratesLst)
//        val listView_rates = findViewById<ListView>(R.id.listview_)
////        val arrayAdapter: ArrayAdapter<String> =
////            ArrayAdapter<String>(this,  listView_rates, ratesLst)
//
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ratesLst)
//        listView_rates.adapter = adapter
////      listView_rates.setAdapter(adapter)
    }

    fun convertListToArray(ratesLst:List<Rate>): ArrayList<Rate> {
        val output = mutableListOf<Rate>()

        for (item in ratesLst){
            output.add(Rate(item.name, item.spotRate))
        }
        return output.toTypedArray().toCollection(ArrayList())
    }

}