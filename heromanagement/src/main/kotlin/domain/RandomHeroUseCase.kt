package domain

import domain.Ability.*
import domain.driven.HeroRepository
import domain.driven.RandomizeRepository
import domain.driving.RandomHero
import infrastructure.InMemoryHeroRepository
import infrastructure.InMemoryRandomizeRepository

// TODO: use dependency injection here
// TODO: add tests
class RandomHeroUseCase : RandomHero {
    private val randomizeRepository: RandomizeRepository = InMemoryRandomizeRepository()
    private val heroRepository: HeroRepository = InMemoryHeroRepository()

    override fun create() {
        val name = randomizeRepository.randomizeName()
        val age = randomizeRepository.randomizeAge()
        val abilities = randomizeRepository.randomizeAbilities()
        val skills = randomizeRepository.randomizeSkills()

        val hero = Hero(
            name = name,
            age = age,
            // TODO: what is better ?
            strength = Strength(abilities.first { it is Strength }.value),
            agility = abilities.find { it is Agility } as Agility,
            perception = abilities.find { it is Perception } as Perception,
//            inventory = TODO(),
            skills = skills,
        )

        println("Creating a random hero: $hero")

        heroRepository.add(hero)
    }
}
