package dk.hovdeforlob4.valutaomregener_android_h4

class CurrencyPresenter {

    //val currency_calculator = CurrencyCalculator() //Relationship: Composition

    constructor(){

    }

    fun setBase(base:String){

    }


    /**
     * this method calculates form one currency base to anther
     * @param base        : String
     * @param value       : Double
     * @param rates_lst   : List<Rate>
     * @return List<Rate>
     */
    fun ConvertCurrency(base: String, value: Double, rates_lst: List<Rate>):List<Rate>{
        //TODO( "not yet implement")
        val calculator = CurrencyCalculator()

        //---Param------------------------//
//        val input_base = ""
//        val rates_lst = listOf<Rate>()
//
//        val intput_value = 100.00
        //---Param_end--------------------//

        val baserate  = calculator.calculateBaseRate(base, rates_lst)
        val value_lst = calculator.calculateValues(base, value, baserate, rates_lst ) //TODO: make overload

        return  value_lst
    }

    /*

     */
}