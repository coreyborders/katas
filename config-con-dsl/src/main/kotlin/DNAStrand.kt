class DNAStrand(val nonJunkLetters: List<Letter>, val totalLetters: Int)

fun create(initializer: DNAStrandBuilder.() -> Unit): DNAStrand {
    return DNAStrandBuilder().apply(initializer).build()
}
