package dk.hovdeforlob4.valutaomregener_android_h4

class MockCurrency : CurrencyDAO {

    constructor(){
    }

    override fun getRates(base: String): List<Rate> {
        //TODO: "Not yet complicity implemented"
        return listOf<Rate>(Rate("Dkk", 1.0))
    }
}