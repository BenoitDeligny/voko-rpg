﻿sealed class Event {

    // TODO: add inventory
    // TODO: add skills
    data class CreateHeroEvent(
        val name: String,
        val age: Int,
        val strength: Int,
        val agility: Int,
        val perception: Int,
    ) : Event() {
        init {
            require(name.all { it.isLetter() }) { "Name must contains only letters." }
            require(age in 15..20) { "Age must be between 15 and 20." }
            require(strength in 2..10) { "Strength must be between 2 and 10." }
            require(agility in 2..10) { "Agility must be between 2 and 10." }
            require(perception in 2..10) { "Perception must be between 2 and 10." }
        }
    }
}