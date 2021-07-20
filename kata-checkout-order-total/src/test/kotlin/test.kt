import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class test {
    val scanner = Scanner()

    @Test
    fun scannedItemHasAPrice() {
        val actual = scanner.acceptItem("soup", 2)
        val expected = 5.98
        assertEquals(actual, expected)
    }

    @Test
    fun scannedSoupHasADifferentPriceThanGum() {
        val actual = scanner.acceptItem("gum",3)
        val expected = 2.97
        assertEquals(actual, expected)
    }

    @Test
    fun overloadedMethodInScannerWorksWithSKU() {
        val actual = scanner.acceptItem(1234, 4)
        val expected = 11.96
        assertEquals(actual, expected)
    }
}

