package domain.model

data class Name(
    val firstName: FirstName,
    val lastName: LastName,
) {
    @JvmInline
    value class FirstName(val value: String) {
        init {
            require(value.all { it.isLetter() }) { "First name must contains only letters." }
        }
    }

    @JvmInline
    value class LastName(val value: String) {
        init {
            require(value.all { it.isLetter() }) { "Last name must contains only letters." }
        }
    }
}