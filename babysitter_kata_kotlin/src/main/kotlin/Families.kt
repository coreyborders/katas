class Families(val preBedtimePay: Int, val postBedtimePay: Int, val postMidnightPay: Int, val bedtime: Int) {

    companion object {
        val familyA = Families(15, 20, 20, 23)
        val familyB = Families(12, 8, 16, 22)
        val familyC = Families(21, 15, 15, 21)
    }
}
