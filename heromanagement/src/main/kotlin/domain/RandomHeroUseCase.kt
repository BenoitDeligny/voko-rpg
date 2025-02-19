package domain

import domain.driven.HeroRepository
import domain.driving.RandomHero
import infrastructure.InMemoryHeroRepository

// TODO: use dependency injection here
// TODO: add tests
class RandomHeroUseCase : RandomHero {
    private val heroRepository: HeroRepository = InMemoryHeroRepository()

    override fun create(hero: Hero) {
        heroRepository.add(hero)
    }
}
