package domain.driven

import domain.model.Hero

interface HeroRepository {
    fun add(hero: Hero)
}