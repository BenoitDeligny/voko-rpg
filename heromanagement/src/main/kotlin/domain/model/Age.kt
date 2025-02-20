package domain.model

@JvmInline
value class Age(val value: Int) {
    init {
        require(value in 15..20) { "Age must be between 15 and 20." }
    }
}