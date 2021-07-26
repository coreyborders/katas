import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DNATest {

    @Test
    fun dna() {
        val dna: DNAStrand = create {
            a()
            g()
            junk()
        }
        assertEquals(3, dna.totalLetters)
        assertEquals(Letter.G, dna.nonJunkLetters.last())
    }
}
