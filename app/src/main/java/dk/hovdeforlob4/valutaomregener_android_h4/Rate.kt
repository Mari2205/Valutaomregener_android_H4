package dk.hovdeforlob4.valutaomregener_android_h4

///**
// * @sse_prop doc on prop        https://www.baeldung.com/kotlin/getters-setters
// * @see_ctor doc on constructor https://kotlinlang.org/docs/classes.html#secondary-constructors
// */
class Rate {
    var name: String = "default value"
    var spotRate: Double = 0.0

    constructor(name: String, spotRate: Double){
        this.name = name
        this.spotRate = spotRate
    }
}