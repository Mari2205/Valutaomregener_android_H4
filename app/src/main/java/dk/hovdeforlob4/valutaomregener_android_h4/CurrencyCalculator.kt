package dk.hovdeforlob4.valutaomregener_android_h4

import kotlin.math.roundToInt

class CurrencyCalculator {

    /**
     * this method will calulte the complt value of usr input
     * @param base      : String
     * @param value     : Double
     * @param rates_lst : List<Rate>
     * @return
     */
    fun calculateValues(usrBate: String, value: Double, divRate: Double, rates_lst: List<Rate>):List<Rate>{
        val resultLst = mutableListOf<Rate>()

        val baseValue = value / divRate

        for (item in rates_lst){
            if (item.name != usrBate) {
                val result2 = baseValue * item.spotRate
                resultLst.add(Rate(item.name, result2.roundToInt().toDouble()))
            }
        }
        return  resultLst
    }


    /**
     * this method will calculate the usr chosen rate form the base rate
     * @param usrBase: String
     * @param rates_lst: List<Rate>
     * @return Double
     */
    fun calculateBaseRate(usrBase: String, rates_lst: List<Rate>):Double {
        var usrRate = 0.0

        for (item in rates_lst){
            if (item.name == usrBase){
                usrRate = item.spotRate
            }
        }

        return usrRate
    }

}