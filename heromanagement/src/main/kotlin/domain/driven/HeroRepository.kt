package domain.driven

import domain.Hero

interface HeroRepository {
    fun add(hero: Hero)
}