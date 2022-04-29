package dk.hovdeforlob4.valutaomregener_android_h4

class MockCurrency : CurrencyDAO {

    val keyPair_rates = HashMap<String, Double>()

    constructor(){
        fillLst()
    }

    fun fillLst(){
        keyPair_rates["AUD"] = 501.50
        keyPair_rates["BGN"] = 380.86
        keyPair_rates["BRL"] = 141.85
        keyPair_rates["CAD"] = 552.37
        keyPair_rates["CHF"] = 728.86

    }

    override fun getRates(base: String): List<Rate> {
        //TODO: "Not yet complicity implemented"
        val ratesLst = mutableListOf<Rate>()

        for (item in keyPair_rates){
            ratesLst.add(Rate(item.key, item.value))
        }

        return ratesLst
    }

}