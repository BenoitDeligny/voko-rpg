package domain

import domain.Ability.*
import domain.ItemResponse.Item
import domain.SkillResponse.Skill
import ulid.ULID
import ulid.ULID.Companion.nextULID

data class Hero(
    val id: ULID = nextULID(),
    val name: Name,
    val age: Age,
    val strength: Strength,
    val agility: Agility,
    val perception: Perception,
    val inventory: List<Item> = emptyList(),
    val skills: List<Skill> = emptyList(),
)

data class Name(
    val firstName: String,
    val lastName: String,
) {
    init {
        require(firstName.all { it.isLetter() }) { "Name must contains only letters." }
        require(lastName.all { it.isLetter() }) { "Name must contains only letters." }
    }
}

@JvmInline
value class Age(val value: Int) {
    init {
        require(value in 15..20) { "Age must be between 15 and 20." }
    }
}

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

