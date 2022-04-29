package dk.hovdeforlob4.valutaomregener_android_h4

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide() // removes the actionbar
        setContentView(R.layout.activity_main)

        /**
         * @see_interface interfaces implementation: https://www.youtube.com/watch?v=5C7W98VVI88
         */
        val mockData_temp = listOf<Rate>(Rate("DKK", 1.0))
        val mockDataObj = MockCurrency()
        val mockData = mockDataObj.getRates("")


        Log.d("mock data", "mock data      : ${mockData[0]}")
        Log.d("mock data", "mock data temp : ${mockData_temp[0].name}")

        var baseArr:Array<String> = getAllCurrencyBase(mockData)
        setSpinner(baseArr)

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
    fun getAllCurrencyBase(rateLst:List<Rate>):Array<String>{

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
}