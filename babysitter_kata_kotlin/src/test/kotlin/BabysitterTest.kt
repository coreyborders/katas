import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BabysitterTest {
    val timeCard = TimeCard()

    @Test
    fun startTimeNotBefore5PM() {
        assertThrows(TooEarlyException::class.java) {
            timeCard.calculatePay(14, 22, Families.familyA)
        }
    }

    @Test
    fun endTimeNotAfter4AM() {
        assertThrows(TooLateException::class.java) {
            timeCard.calculatePay(16, 29, Families.familyB)
        }
    }

    @Test
    fun endTimeNotBeforeStartTime() {
        assertThrows(InvalidTimeException::class.java) {
            timeCard.calculatePay(18, 16, Families.familyC)
        }
    }

    @Test
    fun correctlyProcessesHoursWorkedForFamilyABeforeBedtime() {
        val actual = timeCard.calculatePay(16, 22, Families.familyA)
        val expected = 15*6

        assertEquals(expected, actual)
    }

    @Test
    fun correctlyProcessesHoursWorkedForFamilyAAfterBedtime() {
        val actual = timeCard.calculatePay(23, 24, Families.familyA)
        val expected = 20

        assertEquals(expected, actual)
    }

    @Test
    fun correctlyProcessesHoursWorkedForFamilyAAfterMidnight() {
        val actual = timeCard.calculatePay(24, 28, Families.familyA)
        val expected = 20 * 4

        assertEquals(expected, actual)
    }

    @Test
    fun correctlyProcessesHoursWorkedForFamilyBBeforeBedtime() {
        val actual = timeCard.calculatePay(16, 22, Families.familyB)
        val expected = 12*6

        assertEquals(expected, actual)
    }

    @Test
    fun correctlyProcessesHoursWorkedForFamilyBAfterBedtime() {
        val actual = timeCard.calculatePay(23, 24, Families.familyB)
        val expected = 8

        assertEquals(expected, actual)
    }

    @Test
    fun correctlyProcessesHoursWorkedForFamilyBAfterMidnight() {
        val actual = timeCard.calculatePay(24, 28, Families.familyB)
        val expected = 16 * 4

        assertEquals(expected, actual)
    }

}
