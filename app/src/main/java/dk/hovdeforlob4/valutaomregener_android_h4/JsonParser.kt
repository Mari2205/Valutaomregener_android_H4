package dk.hovdeforlob4.valutaomregener_android_h4


class JsonParser(private val jsonString: String) {

    /**
     * this method takes json string pareses it into CurrencyModel
     * @return CurrencyModel
     */
    fun convertToCurrencyModel():CurrencyModel{
        // Regex patton: /([A-z]){3}":(\d+.\d+)/g

        val arrayOfJsonContains = prepJsonString(jsonString)
        val exchangeRatesPropInfoStr = arrayOfJsonContains[0]
        val exchangeRatesStr = arrayOfJsonContains[1]

        val exchangeRatesPropInfoHashmap = makeHashMap(exchangeRatesPropInfoStr)
        val exchangeRatesLst = convertStringToList(exchangeRatesStr)

        val date      = exchangeRatesPropInfoHashmap.getValue("date")
        val timestamp = exchangeRatesPropInfoHashmap.getValue("timestamp").toInt()
        val base      = exchangeRatesPropInfoHashmap.getValue("base")

        val currencyModel = CurrencyModel()
        currencyModel.date      = date
        currencyModel.timestamp = timestamp
        currencyModel.base      = base
        currencyModel.rates     = exchangeRatesLst

        return currencyModel
    }


    /**
     * this method prepares an json string fx. removes unnecessary chars and splits up in
     * rates and other
     * @param jsonString : String
     * @return Array<String>
     */
    private fun prepJsonString(jsonString: String):Array<String>{
        val cleanedString = jsonString.replace("\"","")
            .replace("{" ,"")
            .replace("}" ,"")

        //val spiltedJson = clinedString.split("rates:").toTypedArray()
        return cleanedString.split("rates:").toTypedArray()
    }


    /**
     * makes hashmap out of string with formatted text:text
     * @param str: String
     * @return Hashmap<String, String>
     */
    private fun makeHashMap(str: String):HashMap<String, String>{
        val propHashmap = HashMap<String, String>()

        val propLst = str.split(",").toTypedArray()

        for (item in propLst){
            if (item.isNotBlank()) {
                val split = item.split(":").toTypedArray()
                val key = split[0]
                val value = split[1]

                propHashmap.put(key,value)
            }
        }
        return propHashmap
    }


    /**
     * this method takes an string of rates an makes it into
     * an list of rates
     * @param jsonStr: String
     * @return List<Rate>
     */
    private fun convertStringToList(jsonStr:String):List<Rate>{
        val currencyLst = mutableListOf<Rate>()
        val stringCurrencyArr = jsonStr.split(",").toTypedArray()

        for (item in stringCurrencyArr){
            val split = item.split(":").toTypedArray()
            val base = split[0]
            val rate = split[1].toDouble()

            currencyLst.add(Rate(base, rate))
        }
        return currencyLst
    }

}