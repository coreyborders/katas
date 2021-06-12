//It's preference, but I prefer to not namespace unless there could be ambiguity.
//You can just make these guys float out here
val familyA = Family(15, 20, 20, 23)
val familyB = Family(12, 8, 16, 22)
val familyC = Family(21, 15, 15, 21)

//Seems like this is a single family
class Family(val preBedtimePay: Int, val postBedtimePay: Int, val postMidnightPay: Int, private val bedtime: Int){

    /**
     * Moving these functions here isn't 100% logical, but it does let us take advantage of bedtime instead of having to pass the family in. It also lets us 'conceal' more of families implementation (bedtime) and instead expose an 'interface' (just give me the hours man!). This helps us be a little more decoupled.
     */
    fun getPostMidnightHours(endTime: Int): Int {
        return when {
            endTime < 24 -> 0
            else -> endTime - 24
        }
    }

    fun getPostBedtimeHours(startTime: Int, endTime: Int,): Int {
        return when {
            endTime <= bedtime -> 0
            startTime >= 24 -> 0
            startTime >= bedtime -> 24 - startTime
            else -> 24 - bedtime
        }
    }

    fun getPreBedtimeHours(startTime: Int, endTime: Int): Int {
        return when {
            bedtime < startTime -> 0
            endTime < bedtime -> endTime - startTime
            else -> bedtime - startTime
        }
    }
}
