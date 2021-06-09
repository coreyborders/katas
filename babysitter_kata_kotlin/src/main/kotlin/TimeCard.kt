class TimeCard {
    fun calculatePay(startTime: Int, endTime: Int, family: Families): Int {
        if (startTime < 16) {
            throw TooEarlyException("Cannot start before 5pm")
        }

        if (endTime > 28) {
            throw TooLateException("Cannot end after 4am")
        }

        if (endTime < startTime) {
            throw InvalidTimeException("Ending time cannot be before start time")
        }

        val preBedtimeHours = getPreBedtimeHours(startTime, endTime, family)
        val postBedtimeHours = getPostBedtimeHours(startTime, endTime, family)
        val postMidnightHours = getPostMidnightHours(endTime)

        return (preBedtimeHours * family.preBedtimePay) + (postBedtimeHours * family.postBedtimePay) + (postMidnightHours * family.postMidnightPay)
    }

    private fun getPostMidnightHours(endTime: Int): Int {
        return when {
            endTime < 24 -> 0
            else -> endTime - 24
        }
    }

    private fun getPostBedtimeHours(startTime: Int, endTime: Int, family: Families): Int {
        return when {
            endTime <= family.bedtime -> 0
            startTime >= 24 -> 0
            startTime >= family.bedtime -> 24 - startTime
            else -> 24 - family.bedtime
        }
    }

    private fun getPreBedtimeHours(startTime: Int, endTime: Int, family: Families): Int {
        return when {
            family.bedtime < startTime -> 0
            endTime < family.bedtime -> endTime - startTime
            else -> family.bedtime - startTime
        }
    }
}
