package dk.hovdeforlob4.valutaomregener_android_h4


class Rate {
    var name: String = "default value"
    var spotRate: Double = 0.0

    constructor(name: String, spotRate: Double){
        this.name = name
        this.spotRate = spotRate
    }
}