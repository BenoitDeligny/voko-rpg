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
    val gear: Gear,
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

data class Gear(
    val helmet: Item,
    val mask: Item,
    val necklace: Item,
    val armor: Item,
    val cloak: Item,
    val costume: Item,
    val bracers: Item,
    val gloves: Item,
    val rightRing: Item,
    val leftRing: Item,
    val belt: Item,
    val boots: Item,
    val mainHand: Item,
    val offHand: Item,
)

data class Item(val id: ULID, val quantity: Int)

data class Skill(val id: ULID, val level: Int)
