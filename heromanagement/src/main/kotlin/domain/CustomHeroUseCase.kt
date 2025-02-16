package domain

import domain.driven.HeroRepository
import domain.driving.CustomHero
import infrastructure.InMemoryHeroRepository

// TODO: use dependency injection here
// TODO: add tests
class CustomHeroUseCase: CustomHero {
    private val heroRepository: HeroRepository = InMemoryHeroRepository()

    override fun create(hero: Hero) {
        heroRepository.add(hero)
    }
}