import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import resources.Item
import java.io.File

class Scanner {

    val string = File("../resources/items.json").toString()
    val json = Json.decodeFromString<Item>(string)

    fun acceptItem(item: String, units: Int): Double {

//        val unitPrice =
//        val unitPrice = when (item) {
//            "soup" -> 2.99
//            "gum" -> 0.99
//            else -> 0.00
//        }
//        return "%.2f".format(unitPrice * units).toDouble()
        return 0.00
    }

    fun acceptItem(item: Int, units: Int): Double {
        val unitPrice = when (item) {
            1234 -> 2.99
            2345 -> 0.99
            else -> 0.00
        }
        return "%.2f".format(unitPrice * units).toDouble()
    }
}
