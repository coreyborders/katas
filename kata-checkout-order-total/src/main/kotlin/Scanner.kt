class Scanner {
    fun acceptItem(item: String, units: Int): Double {
        val unitPrice = when (item) {
            "soup" -> 2.99
            "gum" -> 0.99
            else -> 0.00
        }
        return "%.2f".format(unitPrice * units).toDouble()
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
