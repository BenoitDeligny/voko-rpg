package randomize

import randomize.AbilityName.*
import randomize.SkillName.*
import skill.SkillDatabase

const val AGE_MIN = 15
const val AGE_MAX = 20
const val ABILITY_POINTS = 6
const val SKILL_POINTS = 3

class TheRandomizer {
    private val skillData = SkillDatabase()

    fun randomizeName(): Name = Name(
        firstName = firstNames.random(),
        lastName = lastNames.random()
    )

    fun randomizeAge(): Int = (AGE_MIN..AGE_MAX).random()

    fun randomizeAbilities(): List<Ability> {
        var strength = Ability(Strength, 2)
        var agility = Ability(Agility, 2)
        var perception = Ability(Perception, 2)

        repeat(ABILITY_POINTS) {
            when ((0..2).random()) {
                0 -> strength = strength.copy(value = strength.value + 1)
                1 -> agility = agility.copy(value = agility.value + 1)
                2 -> perception = perception.copy(value = perception.value + 1)
            }
        }

        return listOf(strength, agility, perception)
    }

    fun randomizeSkills(): List<Skill> = skillData.getSkills()
        .shuffled()
        .take(SKILL_POINTS)
        .map {
            Skill(
                name = when (it.name) {
                    "Acrobatics" -> Acrobatics
                    "Climbing" -> Climbing
                    "Demining" -> Demining
                    "Fencing" -> Fencing
                    "FirstAid" -> FirstAid
                    "LockPicking" -> LockPicking
                    "Mechanics" -> Mechanics
                    "Observation" -> Observation
                    "Piloting" -> Piloting
                    "Shooting" -> Shooting
                    "Sports" -> Sports
                    "Stealth" -> Stealth
                    "Survival" -> Survival
                    "Swimming" -> Swimming
                    "Wrestling" -> Wrestling
                    else -> throw IllegalArgumentException("Unknown skill name")
                },
                level = 1
            )
        }
        .toList()

    fun randomizeInventory() {
    }
}
