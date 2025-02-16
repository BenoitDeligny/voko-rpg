package infrastructure

import domain.Hero
import domain.driven.HeroRepository

class InMemoryHeroRepository : HeroRepository {
    private val heroes = mutableSetOf<Hero>()

    override fun add(hero: Hero) {
        heroes.add(hero)
    }
}