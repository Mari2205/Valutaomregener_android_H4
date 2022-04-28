package dk.hovdeforlob4.valutaomregener_android_h4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * @see_interface interfaces implementation: https://www.youtube.com/watch?v=5C7W98VVI88
         */
        val mokeData_temp = listOf<Rate>(Rate("DKK", 1.0))
        val mockDataObj = MockCurrency()
        val mockData = mockDataObj.getRates("")


        Log.d("mock data", "mock data      : ${mockData[0]}")
        Log.d("mock data", "mock data temp : ${mokeData_temp[0].name}")
        val temp = ""
    }
}