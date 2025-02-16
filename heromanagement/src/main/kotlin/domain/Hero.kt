package domain

import ulid.ULID
import ulid.ULID.Companion.nextULID

data class Hero(
    val id: ULID = nextULID(),
    val name: Name,
    val age: Age,
    val strength: Ability,
    val agility: Ability,
    val perception: Ability,
    val inventory: Inventory = Inventory(),
    val skills: List<String> = emptyList(),
) {
    val powerLevel = PowerLevel(strength.value + agility.value + perception.value)
}

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

@JvmInline
value class PowerLevel(val value: Int)

// TODO: replace String by Item
//data class Item(
//    val id: ULID = nextULID(),
//    val name: String,
//    val powerBonus: Int,
//    val damagesBonus: Int,
//    val protectionBonus: Int,
//)
@JvmInline
value class Inventory(val value: List<String> = emptyList())

// TODO: replace String by Skill
@JvmInline
value class Skills(val value: List<String>)
