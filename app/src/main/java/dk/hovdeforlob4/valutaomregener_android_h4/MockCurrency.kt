package dk.hovdeforlob4.valutaomregener_android_h4

class MockCurrency : CurrencyDAO {

    constructor(){
        fullLst()
    }

    val theMap = HashMap<String, Double>()
    fun fullLst(){
        theMap["AUD"] = 501.50
        theMap["BGN"] = 380.86
        theMap["BRL"] = 141.85
        theMap["CAD"] = 552.37
        theMap["CHF"] = 728.86

    }

    override fun getRates(base: String): List<Rate> {
        //TODO: "Not yet complicity implemented"
        return listOf<Rate>(Rate("Dkk", 1.0))
    }

}