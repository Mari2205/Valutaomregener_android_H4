package dk.hovdeforlob4.valutaomregener_android_h4

import kotlin.math.roundToInt

class CurrencyCalculator {

    constructor(){

    }


    /**
     * this method will calulte the complt value of usr input
     * @param base      : String
     * @param value     : Double
     * @param rates_lst : List<Rate>
     * @return
     */
    fun calcultValue(usrRate: String, divRate: Double, value: Double, rates_lst: List<Rate>):List<Rate>{
        //TODO: clien up remove static code
        val output = mutableListOf<Rate>()


        val result0 = value / divRate
        val result1 = result0 * 1.05

        for (item in rates_lst){
            if (item.name != usrRate) {
                val result2 = result0 * item.spotRate
                output.add(Rate(item.name, result2.roundToInt().toDouble()))
            }
        }

        return  output

    }

    /**
     * this method will calculte the usr choosen rate form the base rate
     * @param base: String
     * @param rate: Double
     * @return Double
     */
    fun calcultRates(usrBase: String, rates_lst: List<Rate>):Pair<Double, Double>{
        //TODO("not yet implement")
        var output = 0.0
        var baseRate = 0.0
        var usrRate = 0.0

        for (item in rates_lst){
            if (item.name == "EUR"){
                baseRate = item.spotRate
            }
            if (item.name == usrBase){
                usrRate = item.spotRate
            }
        }


        return baseRate to usrRate


    }
}