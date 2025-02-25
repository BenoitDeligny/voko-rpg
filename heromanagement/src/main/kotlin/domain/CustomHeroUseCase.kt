package domain

import domain.driven.HeroRepository
import domain.driving.CustomHero
import domain.model.Hero
import infrastructure.InMemoryHeroRepository

// use dependency injection here
// add tests
class CustomHeroUseCase: CustomHero {
    private val heroRepository: HeroRepository = InMemoryHeroRepository()

    override fun create(hero: Hero) {
        heroRepository.add(hero)
    }
}