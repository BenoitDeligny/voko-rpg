package randomize

import skill.SkillDatabase

const val AGE_MIN = 15
const val AGE_MAX = 20
const val ABILITY_POINTS = 6
const val SKILL_POINTS = 3

class TheRandomizer {
    private val skillData = SkillDatabase()

    fun randomizeName(): Name {
        println("Randomizing name")

        return Name(
            firstName = firstNames.random(),
            lastName = lastNames.random()
        )
    }

    fun randomizeAge(): Int {
        println("Randomizing age")

        return (AGE_MIN..AGE_MAX).random()
    }

    fun randomizeAbilities(): List<Ability> {
        println("Randomizing abilities")

        var strength = Ability("strength", 2)
        var agility = Ability("agility", 2)
        var perception = Ability("perception", 2)

        repeat(ABILITY_POINTS) {
            when ((0..2).random()) {
                0 -> strength = strength.copy(value = strength.value + 1)
                1 -> agility = agility.copy(value = agility.value + 1)
                2 -> perception = perception.copy(value = perception.value + 1)
            }
        }

        return listOf(strength, agility, perception)
    }

    fun randomizeInventory() {
        println("Randomizing inventory")
    }

    fun randomizeSkills(): List<Skill> {
        println("Randomizing skills")

        return skillData.getSkills()
            .shuffled()
            .take(SKILL_POINTS)
            .map { Skill(name = it.name, level = 1) }
            .toList()
    }
}
