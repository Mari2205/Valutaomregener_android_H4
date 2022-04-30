package dk.hovdeforlob4.valutaomregener_android_h4

class CurrencyModel {
    var timestamp: Int = 0
    var date: String = "defult"
    var base: String = "defult"
    var rates: List<Rate> = listOf(Rate("defult", 0.0))
}