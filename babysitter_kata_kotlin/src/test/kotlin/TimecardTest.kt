import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class TimecardTest {
    //Having a shared object under test can make things easier to be mutable
    //It's better to new the object up in each test, that way it's much less likely you've accidentally created inter-test dependencies

    @Test
    fun startTimeNotBefore5PM() {
        //This assert throws feels a little cleaner / more kotliny to me. It doesn't require the ::java.class
        assertThrows<TooEarlyException>{
            TimeCard().calculatePay(14, 22, familyA)
        }
    }

    @Test
    fun endTimeNotAfter4AM() {
        assertThrows(TooLateException::class.java) {
            TimeCard().calculatePay(16, 29, familyB)
        }
    }

    @Test
    fun endTimeNotBeforeStartTime() {
        assertThrows(InvalidTimeException::class.java) {
            TimeCard().calculatePay(18, 16, familyC)
        }
    }

    @Test
    fun correctlyProcessesHoursWorkedForFamilyABeforeBedtime() {
        val actual = TimeCard().calculatePay(16, 22, familyA)
        val expected = 15*6

        assertEquals(expected, actual)
    }

    @Test
    fun correctlyProcessesHoursWorkedForFamilyAAfterBedtime() {
        val actual = TimeCard().calculatePay(23, 24, familyA)
        val expected = 20

        assertEquals(expected, actual)
    }

    @Test
    fun correctlyProcessesHoursWorkedForFamilyAAfterMidnight() {
        val actual = TimeCard().calculatePay(24, 28, familyA)
        val expected = 20 * 4

        assertEquals(expected, actual)
    }

    @Test
    fun correctlyProcessesHoursWorkedForFamilyBBeforeBedtime() {
        val actual = TimeCard().calculatePay(16, 22, familyB)
        val expected = 12*6

        assertEquals(expected, actual)
    }

    @Test
    fun correctlyProcessesHoursWorkedForFamilyBAfterBedtime() {
        val actual = TimeCard().calculatePay(23, 24, familyB)
        val expected = 8

        assertEquals(expected, actual)
    }

    @Test
    fun correctlyProcessesHoursWorkedForFamilyBAfterMidnight() {
        val actual = TimeCard().calculatePay(24, 28, familyB)
        val expected = 16 * 4

        assertEquals(expected, actual)
    }

}
