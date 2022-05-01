package dk.hovdeforlob4.valutaomregener_android_h4

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import dk.hovdeforlob4.valutaomregener_android_h4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dataObj = MockCurrency();
    private val parser = JsonParser(dataObj.jsonRespose())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide() // removes the actionbar
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val mockData = dataObj.jsonRespose()
//        val j = JsonParser(mockData)
        val currency = parser.convertToCurrencyModel()


        var baseArr: Array<String> = getAllBaseCurrency(currency.rates)
        setSpinner(baseArr)

    }


     fun calcBtn(view: View){
        val textBox = findViewById<EditText>(R.id.editText_valuta)

//        val mockDataJson = dataObj.jsonRespose()
//        val parser = JsonParser(mockDataJson)
        val data = parser.convertToCurrencyModel()

        val usrBase: String = getSpinnerSelectedValue()
        val inputValue = textBox.text.toString().toDouble()

        val currencyPresenter = CurrencyPresenter()
        val completeValueLst = currencyPresenter.convertCurrency(usrBase, inputValue, data.rates)

        val arr = convertListToArray(completeValueLst)
        setListView(arr)
    }


    private fun getSpinnerSelectedValue():String {
        val spinner_wig = findViewById<Spinner>(R.id.spinner_base)
        val usrCurrencyBase: String = spinner_wig.getSelectedItem().toString()

        return usrCurrencyBase
    }


    /**
     * this method takes an list of Rates og sorter all currency bases into an array of string
     * @see_loops Doc for kotlin Loops : https://kotlinlang.org/docs/control-flow.html#for-loops
     */
    private fun getAllBaseCurrency(rateLst: List<Rate>): Array<String> {
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
    private fun setSpinner(baseArr: Array<String>) {
        val spinnerLst = findViewById<Spinner>(R.id.spinner_base)

        val adapterArr = ArrayAdapter(this, android.R.layout.simple_spinner_item, baseArr)
        adapterArr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerLst!!.setAdapter(adapterArr)
    }


    /**
     * this method sets listview widget with a custom layout with currency rates (rate(DKK) and values(1.553))
     */
    private fun setListView(ratesLst: ArrayList<Rate>) {
        binding.listview.adapter = ListViewAdapter(this, ratesLst)

    }


    private fun convertListToArray(ratesLst: List<Rate>): ArrayList<Rate> {
        val currencyLst = mutableListOf<Rate>()

        for (item in ratesLst) {
            currencyLst.add(Rate(item.name, item.spotRate))
        }
        return currencyLst.toTypedArray().toCollection(ArrayList())
    }
}