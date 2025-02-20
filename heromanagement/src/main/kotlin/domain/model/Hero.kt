package domain.model

import domain.model.Ability.*
import domain.model.ItemResponse.Item
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
