package dk.hovdeforlob4.valutaomregener_android_h4

interface CurrencyDAO {
    fun getRates():List<Rate>
}