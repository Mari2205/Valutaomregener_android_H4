package dk.hovdeforlob4.valutaomregener_android_h4

class CurrencyPresenter {

    /**
     * this method calculates form one currency base to anther
     * @param base        : String
     * @param value       : Double
     * @param rates_lst   : List<Rate>
     * @return List<Rate>
     */
    fun convertCurrency(base: String, value: Double, rates_lst: List<Rate>):List<Rate>{
        val calculator = CurrencyCalculator()

        val baseRate  = calculator.calculateBaseRate(base, rates_lst)
        val valueLst = calculator.calculateValues(base, value, baseRate, rates_lst )

        return  valueLst
    }

}