class DNAStrandBuilder {
    private val strand = mutableListOf<Letter>()

    fun a() {
        strand.add(Letter.A)
    }

    fun c() {
        strand.add(Letter.C)
    }

    fun g() {
        strand.add(Letter.G)
    }

    fun t() {
        strand.add(Letter.T)
    }

    fun junk() {
        strand.add(Letter.JUNK)
    }

    fun build(): DNAStrand {
        val totalLetters = strand.size
        val nonJunkLetters = mutableListOf<Letter>()
        for (letter in strand) {
            if (letter != Letter.JUNK) {
                nonJunkLetters.add(letter)
            }
        }
        return DNAStrand(nonJunkLetters, totalLetters)
    }
}
