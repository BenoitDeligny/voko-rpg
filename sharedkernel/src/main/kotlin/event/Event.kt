package event

sealed interface Event {

    data class CreateHeroEvent(
        val name: String,
        val age: Int,
        val strength: Int,
        val agility: Int,
        val perception: Int,
        val gear: GearEvent,
        val inventory: List<ItemEvent>,
        val skills: List<SkillEvent>,
    ) : Event {
        init {
            require(name.all { it.isLetter() }) { "Name must contains only letters." }
            require(age in 15..20) { "Age must be between 15 and 20." }
            require(strength in 2..10) { "Strength must be between 2 and 10." }
            require(agility in 2..10) { "Agility must be between 2 and 10." }
            require(perception in 2..10) { "Perception must be between 2 and 10." }
        }

        data class GearEvent(
            val helmet: ItemEvent,
            val mask: ItemEvent,
            val necklace: ItemEvent,
            val armor: ItemEvent,
            val cloak: ItemEvent,
            val costume: ItemEvent,
            val bracers: ItemEvent,
            val gloves: ItemEvent,
            val rightRing: ItemEvent,
            val leftRing: ItemEvent,
            val belt: ItemEvent,
            val boots: ItemEvent,
            val mainHand: ItemEvent,
            val offHand: ItemEvent,
        )

        data class ItemEvent(
            val id: String,
            val quantity: Int,
        )

        data class SkillEvent(
            val id: String,
            val level: Int,
        )
    }
}
