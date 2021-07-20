class Scanner {
    fun acceptItem(item: String): Double {
        return when (item) {
            "soup" -> 2.99
            "gum" -> 0.99
            else -> 0.00
        }
    }
}
