package domain.model

import domain.model.Ability.*
import ulid.ULID
import ulid.ULID.Companion.nextULID

data class Hero(
    val id: ULID = nextULID(),
    val name: Name,
    val age: Age,
    val strength: Strength,
    val agility: Agility,
    val perception: Perception,
    val inventory: List<ItemBis> = emptyList(),
//    val inventory: List<Item> = emptyList(),
    val skills: List<SkillBis> = emptyList(),
//    val skills: List<Skill> = emptyList(),
)
