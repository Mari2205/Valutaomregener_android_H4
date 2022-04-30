package dk.hovdeforlob4.valutaomregener_android_h4

class JsonParser(private val jsonString: String) {

    fun ConvertToCurrercyModel(){
        // Regex patton: /([A-z]){3}":(\d+.\d+)/g
        //val re = jsonString.matches(Regex("/([A-z]){3}\":(\\d+.\\d+)/g"))
        val ratesAndValuesLst = mutableListOf<Rate>()
        val keyPair_ratesAndValues = HashMap<String, Double>()

        println(jsonString)


        val breakporint_stop = ""
    }

    /**
     * this method takes an string of rates an makes it into
     * an hashmap(kayvalue pairs) of string and doublet (cunnency base and rates)
     */
    private fun convertStringToHashMap(baseAndRates:String):HashMap<String, Double>{
        //TODO: convert hashmap to list<Rate>
        val baseAndRates_hashmap = HashMap<String, Double>()

        val clinedString = jsonString.replace("\"","")
            .replace("{" ,"")
            .replace("}" ,"")
        val rates = clinedString.split(",").toTypedArray()

        for (item in rates){
            val split = item.split(":").toTypedArray()
            baseAndRates_hashmap[split[0]] = split[1].toDouble()
        }

        return baseAndRates_hashmap
    }

}