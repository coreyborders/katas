import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class test {
    @Test
    fun scannedItemHasAPrice() {
        val actual = acceptItem(soup)
        val expected = 2.99
        assertEquals(actual, expected)
    }
}

