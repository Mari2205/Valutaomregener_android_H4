package dk.hovdeforlob4.valutaomregener_android_h4

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import dk.hovdeforlob4.valutaomregener_android_h4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide() // removes the actionbar
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        /**
//         * @see_interface interfaces implementation: https://www.youtube.com/watch?v=5C7W98VVI88
//         */

        val mockDataObj = MockCurrency()
        val mockData = mockDataObj.getRates("")

        var baseArr: Array<String> = getAllBaseCurrency(mockData)
        setSpinner(baseArr)

    }


    fun calcBtn(view: View){
        val textbox = findViewById<EditText>(R.id.editText_valuta)

        val mockDataObj = MockCurrency()
        val mockDataJson = mockDataObj.jsonRespose()
        val jparser = JsonParser(mockDataJson)

        val data = jparser.convertToCurrencyModel()

        val spinner_wig = findViewById<Spinner>(R.id.spinner_base)
        val usrBase: String = spinner_wig.getSelectedItem().toString()

        val input_value = textbox.text.toString().toDouble()

        val currencyPresenter = CurrencyPresenter()
        val completValueLst = currencyPresenter.convertCurrency(usrBase, input_value, data.rates)

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
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, baseArr)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerLst!!.setAdapter(aa)
    }


    /**
     * this method sets listview wiget with a custom layout with cuency rates (rate(DKK) and values(1.553))
     */
    fun setListView(ratesLst: ArrayList<Rate>) {
        Log.d("list_view", "inside methode")
        binding.listview.adapter = ListViewAdapter(this, ratesLst)

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