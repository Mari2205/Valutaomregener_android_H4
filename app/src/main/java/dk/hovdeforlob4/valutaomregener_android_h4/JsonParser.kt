package dk.hovdeforlob4.valutaomregener_android_h4


//TODO: better names
class JsonParser(private val jsonString: String) {

    /**
     * this method takes json string pareses it into CurrencyModel
     * @return CurrencyModel
     */
    fun convertToCurrencyModel():CurrencyModel{
        // Regex patton: /([A-z]){3}":(\d+.\d+)/g
        //val re = jsonString.matches(Regex("/([A-z]){3}\":(\\d+.\\d+)/g"))

        val spiltedJson = prepJsonString(jsonString)
        val other = spiltedJson[0]
        val baseAndRats = spiltedJson[1]

        val other_hashmap = makeHashMap(other)
        val baseAndRates = convertStringToList(baseAndRats)

        val date      = other_hashmap.getValue("date")
        val timestamp = other_hashmap.getValue("timestamp").toInt()
        val base      = other_hashmap.getValue("base")

        val currencyModel = CurrencyModel()
        currencyModel.date      = date
        currencyModel.timestamp = timestamp
        currencyModel.base      = base
        currencyModel.rates     = baseAndRates

        return currencyModel
    }


    /**
     * this method prepes an json string fx. removes unseary chars and splits up in
     * rates and other
     * @param jsonString : String
     * @return Array<String>
     */
    private fun prepJsonString(jsonString: String):Array<String>{
        val clinedString = jsonString.replace("\"","")
            .replace("{" ,"")
            .replace("}" ,"")

        val spiltedJson = clinedString.split("rates:").toTypedArray()
        return spiltedJson
    }


    /**
     * makes hashmap out of string with formatted text:text
     * @param str: String
     * @return Hashmap<String, String>
     */
    private fun makeHashMap(str: String):HashMap<String, String>{
        val hashMap = HashMap<String, String>()

        val lst = str.split(",").toTypedArray()

        for (item in lst){
            if (item.isNotBlank()) {
                val split = item.split(":").toTypedArray()
                val key = split[0]
                val value = split[1]

                hashMap.put(key,value)
            }
        }

        return hashMap
    }


    /**
     * this method takes an string of rates an makes it into
     * an List<Rate>
     * @param jsonStr: String
     * @return List<Rate>
     */
    private fun convertStringToList(jsonStr:String):List<Rate>{
        val baseAndRates = mutableListOf<Rate>()


        val rates = jsonStr.split(",").toTypedArray()

        for (item in rates){
            val split = item.split(":").toTypedArray()
            val base = split[0]
            val rate = split[1].toDouble()

            baseAndRates.add(Rate(base, rate))
        }

        return baseAndRates
    }


}