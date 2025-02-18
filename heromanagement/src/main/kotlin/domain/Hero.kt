package domain

import domain.ItemResponse.Item
import domain.SkillResponse.Skill
import ulid.ULID
import ulid.ULID.Companion.nextULID

data class Hero(
    val id: ULID = nextULID(),
    val name: Name,
    val age: Age,
    val strength: Ability,
    val agility: Ability,
    val perception: Ability,
    val inventory: List<Item> = emptyList(),
    val skills: List<Skill> = emptyList(),
)

@JvmInline
value class Name(val value: String) {
    init {
        require(value.all { it.isLetter() }) { "Name must contains only letters." }
    }
}

@JvmInline
value class Age(val value: Int) {
    init {
        require(value in 15..20) { "Age must be between 15 and 20." }
    }
}

@JvmInline
value class Ability(val value: Int) {
    init {
        require(value in 2..10) { "Ability must be between 2 and 10." }
    }
}

