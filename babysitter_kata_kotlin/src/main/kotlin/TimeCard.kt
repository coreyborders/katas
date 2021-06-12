/**
    Currently this guy has no state (variables). If that's the case, what's the value of him being a class?
     If you want to name space the function, you could make him an object. Then you don't need to new him up.
     Or you could make him a free floating function (just calc pay), this would be very functional.
     Finally, you could make him 'more of an object'. One smell that you could use an object is when a method signature has a lot
     of parameters.
     In our case, would a time card ever be used for more than one family? Logically it makes sense that a timecard would only
     be made for one family at a time. In this case you could make family a private, immutable variable and new each timeacard
     up with a family, and then not need to pass that in to each function.
 *
 */
class TimeCard {
    fun calculatePay(startTime: Int, endTime: Int, family: Family): Int {
        validate(startTime, endTime)

        val preBedtimeHours = family.getPreBedtimeHours(startTime, endTime)
        val postBedtimeHours = family.getPostBedtimeHours(startTime, endTime)
        val postMidnightHours = family.getPostMidnightHours(endTime)

        /**
         * Continuing down the train of moving things that use family's properties into family, could we move this whole method into family? Does it even make sense to have a timecard object?
         * If family has all the info needed besides start and end time, could we create a family method like: family.calculatePay(startTime: Int, endTime: Int)?
         */
        return (preBedtimeHours * family.preBedtimePay) + (postBedtimeHours * family.postBedtimePay) + (postMidnightHours * family.postMidnightPay)
    }

    //I don't think this is great, but worth showing as just an alternative
    //sometimes when you have a lot of checks and they're just throwing exceptions
    //it can be nice to hide them away from your 'main' method
    private fun validate(startTime: Int, endTime: Int) {
        if (startTime < 16) {
            throw TooEarlyException("Cannot start before 5pm")
        }

        if (endTime > 28) {
            throw TooLateException("Cannot end after 4am")
        }

        if (endTime < startTime) {
            throw InvalidTimeException("Ending time cannot be before start time")
        }
    }

}
