package domain

import domain.driven.HeroRepository
import domain.driven.NameRepository
import domain.driven.SkillRepository
import domain.driving.RandomHero
import domain.model.*
import domain.model.Ability.*
import domain.model.Skill.*
import infrastructure.InMemoryHeroRepository
import infrastructure.InMemoryNameRepository
import infrastructure.InMemorySkillRepository

private const val AGE_MIN = 15
private const val AGE_MAX = 20
private const val ABILITY_POINTS = 6
private const val SKILL_POINTS = 3

// TODO: use dependency injection here
// TODO: add tests
class RandomHeroUseCase : RandomHero {
    private val nameRepository: NameRepository = InMemoryNameRepository()
    private val skillRepository: SkillRepository = InMemorySkillRepository()
    private val heroRepository: HeroRepository = InMemoryHeroRepository()

    override fun create() {
        val randomAbilities = randomAbilities()

        val hero = Hero(
            name = randomName(),
            age = randomAge(),
            strength = randomAbilities.first { it is Strength } as Strength,
            agility = randomAbilities.first { it is Agility } as Agility,
            perception = randomAbilities.first { it is Perception } as Perception,
//            inventory = TODO(),
//            skills = randomSkills(),
        )

        println("Creating a random hero: $hero")

        heroRepository.add(hero)
    }

    private fun randomName(): Name = Name(
        firstName = nameRepository.firstNames().random(),
        lastName = nameRepository.lastNames().random()
    )

    private fun randomAge(): Age = Age((AGE_MIN..AGE_MAX).random())

    private fun randomAbilities(): List<Ability> {
        var strength = Strength(2)
        var agility = Agility(2)
        var perception = Perception(2)

        repeat(ABILITY_POINTS) {
            when ((0..2).random()) {
                0 -> strength = strength.copy(value = strength.value + 1)
                1 -> agility = agility.copy(value = agility.value + 1)
                2 -> perception = perception.copy(value = perception.value + 1)
            }
        }

        return listOf(strength, agility, perception)
    }

    private fun randomSkills(): List<Skill> = skillRepository.skills()
        .shuffled()
        .take(SKILL_POINTS)
        .mapNotNull {
            when (it) {
                is Acrobatics -> it.copy(level = 1)
                is Climbing -> it.copy(level = 1)
                is Demining -> it.copy(level = 1)
                is Fencing -> it.copy(level = 1)
                is FirstAid -> it.copy(level = 1)
                is LockPicking -> it.copy(level = 1)
                is Mechanics -> it.copy(level = 1)
                is Observation -> it.copy(level = 1)
                is Piloting -> it.copy(level = 1)
                is Shooting -> it.copy(level = 1)
                is Sports -> it.copy(level = 1)
                is Stealth -> it.copy(level = 1)
                is Survival -> it.copy(level = 1)
                is Swimming -> it.copy(level = 1)
                is Wrestling -> it.copy(level = 1)
                is SkillNotFound -> null
            }
        }

    private fun randomInventory() {

    }
}
