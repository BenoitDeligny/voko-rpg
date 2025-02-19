package exposition

import domain.*
import domain.Ability.*
import domain.ItemResponse.Item
import domain.ItemResponse.ItemNotFound
import domain.SkillResponse.Skill
import domain.SkillResponse.SkillNotFound
import domain.driving.CustomHero
import domain.driving.GetItem
import domain.driving.GetSkill
import event.Event
import event.Event.CustomHeroEvent
import event.Event.CustomHeroEvent.ItemEvent
import event.Event.CustomHeroEvent.SkillEvent
import event.SimpleEventBus
import event.Subscriber

// TODO: as of today, this is a placeholder
// but for now it "replace" a classic controller

// TODO: use dependency injection here
// TODO: add tests
class CreateCustomHeroHandler : Subscriber<CustomHeroEvent> {
    private val eventBus = SimpleEventBus<Event>()
    private val customHeroUseCase: CustomHero = CustomHeroUseCase()
    private val getItemUseCase: GetItem = GetItemUseCase()
    private val getSkillUseCase: GetSkill = GetSkillUseCase()

    init {
        eventBus.register(this)
    }

    override fun invoke(event: CustomHeroEvent) {
        println("Creating a custom hero: $event")

        val hero = event.toHeroDomain()
        println("Hero to create: $hero")

        customHeroUseCase.create(hero)
    }

    private fun CustomHeroEvent.toHeroDomain() = Hero(
        name = Name(name.firstName, name.lastName),
        age = Age(age),
        strength = Strength(strength),
        agility = Agility(agility),
        perception = Perception(perception),
        inventory = inventory.toItemDomain(),
        skills = skills.toSkillDomain(),
    )

    private fun List<ItemEvent>.toItemDomain() = mapNotNull {
        when (val item = getItemUseCase.getItem(it.id)) {
            is Item -> Item(id = item.id, item.name)
            is ItemNotFound -> null
        }
    }

    private fun List<SkillEvent>.toSkillDomain() = mapNotNull {
        when (val skill = getSkillUseCase.getSkill(it.id)) {
            is Skill -> Skill(name = skill.name, level = it.level)
            is SkillNotFound -> null
        }
    }
}


