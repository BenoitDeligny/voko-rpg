package domain

import domain.driven.HeroRepository
import domain.driven.ItemRepository
import domain.driven.NameRepository
import domain.driving.RandomHero
import domain.model.*
import domain.model.Ability.*
import domain.model.ItemResponse.Item
import domain.model.ItemResponse.Weapon
import domain.model.Skill.*
import domain.model.Skills.Companion.skills
import infrastructure.InMemoryHeroRepository
import infrastructure.InMemoryItemRepository
import infrastructure.InMemoryNameRepository

private const val AGE_MIN = 15
private const val AGE_MAX = 20
private const val ABILITY_POINTS = 6
private const val SKILL_POINTS = 3
private const val NUMBER_OF_WEAPONS = 1
private const val NUMBER_OF_ITEMS = 1
private const val NUMBER_OF_CONSUMABLES = 1

// use dependency injection here
// add tests
class RandomHeroUseCase : RandomHero {
    private val nameRepository: NameRepository = InMemoryNameRepository()
    private val heroRepository: HeroRepository = InMemoryHeroRepository()
    private val itemRepository: ItemRepository = InMemoryItemRepository()

    override fun create() {
        val randomAbilities = randomAbilities()

        val hero = Hero(
            name = randomName(),
            age = randomAge(),
            strength = randomAbilities.first { it is Strength } as Strength,
            agility = randomAbilities.first { it is Agility } as Agility,
            perception = randomAbilities.first { it is Perception } as Perception,
            inventory = randomInventory(),
            skills = randomSkills(),
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

    private fun randomInventory(): List<Item> {
        val weapons = randomWeapons()

//        val other = itemRepository.starterItems()
//            .filterIsInstance<Item>()
//            .filter { it.type != ItemType.WEAPON && it.type != ItemType.CONSUMABLE }
//            .shuffled()
//            .take(NUMBER_OF_ITEMS)
//
//        val consumables = itemRepository.starterItems()
//            .filterIsInstance<Item>()
//            .filter { it.type == ItemType.CONSUMABLE }
//            .shuffled()
//            .take(NUMBER_OF_CONSUMABLES)

        return weapons //+ other + consumables
    }

    private fun randomWeapons(): List<Weapon> {
        return List(NUMBER_OF_WEAPONS) {
            val d100Roll = (1..100).random()

            when {
                d100Roll <= 34 -> listOf(itemRepository.starterOneHandedWeapons().random())
                d100Roll <= 67 -> listOf(itemRepository.starterTwoHandedWeapons().random())
                else -> List(2) { itemRepository.starterLightWeapons().random() }
            }
        }.flatten()
    }

    private fun randomSkills(): Skills = skills
        .shuffled()
        .take(SKILL_POINTS)
        .fold(Skills()) { skills, skill ->
            when (skill) {
                "Acrobatics" -> skills.copy(acrobatics = Acrobatics(1))
                "Climbing" -> skills.copy(climbing = Climbing(1))
                "Demining" -> skills.copy(demining = Demining(1))
                "Fencing" -> skills.copy(fencing = Fencing(1))
                "FirstAid" -> skills.copy(firstAid = FirstAid(1))
                "LockPicking" -> skills.copy(lockPicking = LockPicking(1))
                "Mechanics" -> skills.copy(mechanics = Mechanics(1))
                "Observation" -> skills.copy(observation = Observation(1))
                "Piloting" -> skills.copy(piloting = Piloting(1))
                "Shooting" -> skills.copy(shooting = Shooting(1))
                "Sports" -> skills.copy(sports = Sports(1))
                "Stealth" -> skills.copy(stealth = Stealth(1))
                "Survival" -> skills.copy(survival = Survival(1))
                "Swimming" -> skills.copy(swimming = Swimming(1))
                "Wrestling" -> skills.copy(wrestling = Wrestling(1))
                else -> skills
            }
        }
}
