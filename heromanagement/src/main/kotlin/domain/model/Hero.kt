package domain.model

import domain.model.Ability.*
import domain.model.ItemResponse.Item
import domain.model.Skill.*
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
    val skills: Skills = Skills(),
)

data class Skills(
    val acrobatics: Acrobatics = Acrobatics(0),
    val climbing: Climbing = Climbing(0),
    val demining: Demining = Demining(0),
    val fencing: Fencing = Fencing(0),
    val firstAid: FirstAid = FirstAid(0),
    val lockPicking: LockPicking = LockPicking(0),
    val mechanics: Mechanics = Mechanics(0),
    val observation: Observation = Observation(0),
    val piloting: Piloting = Piloting(0),
    val shooting: Shooting = Shooting(0),
    val sports: Sports = Sports(0),
    val stealth: Stealth = Stealth(0),
    val survival: Survival = Survival(0),
    val swimming: Swimming = Swimming(0),
    val wrestling: Wrestling = Wrestling(0),
) {
    companion object {
        val skills = listOf(
            "Acrobatics",
            "Climbing",
            "Demining",
            "Fencing",
            "FirstAid",
            "LockPicking",
            "Mechanics",
            "Observation",
            "Piloting",
            "Shooting",
            "Sports",
            "Stealth",
            "Survival",
            "Swimming",
            "Wrestling"
        )
    }
}