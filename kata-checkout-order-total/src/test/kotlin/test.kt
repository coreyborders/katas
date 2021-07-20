import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class test {
    val scanner = Scanner()

    @Test
    fun scannedItemHasAPrice() {
        val actual = scanner.acceptItem("soup")
        val expected = 2.99
        assertEquals(actual, expected)
    }

}

