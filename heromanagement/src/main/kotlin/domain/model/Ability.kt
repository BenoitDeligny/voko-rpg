package domain.model

sealed class Ability {
    abstract val value: Int

    data class Strength(override val value: Int) : Ability() {
        init {
            require(value in 2..10) { "Strength must be between 2 and 10." }
        }
    }

    data class Agility(override val value: Int) : Ability() {
        init {
            require(value in 2..10) { "Agility must be between 2 and 10." }
        }
    }

    data class Perception(override val value: Int) : Ability() {
        init {
            require(value in 2..10) { "Perception must be between 2 and 10." }
        }
    }
}