package exposition

import domain.*
import domain.ItemResponse.Item
import domain.ItemResponse.ItemNotFound
import domain.SkillResponse.Skill
import domain.SkillResponse.SkillNotFound
import domain.driving.CustomHero
import domain.driving.GetItem
import domain.driving.GetSkill
import event.Event
import event.Event.CreateHeroEvent
import event.Event.CreateHeroEvent.ItemEvent
import event.Event.CreateHeroEvent.SkillEvent
import event.SimpleEventBus
import event.Subscriber

// TODO: as of today, this is a placeholder
// but for now it "replace" a classic controller

// TODO: use dependency injection here
// TODO: add tests
class CreateHeroHandler : Subscriber<CreateHeroEvent> {
    private val eventBus = SimpleEventBus<Event>()
    private val customHeroUseCase: CustomHero = CustomHeroUseCase()
    private val getItemUseCase: GetItem = GetItemUseCase()
    private val getSkillUseCase: GetSkill = GetSkillUseCase()

    init {
        eventBus.register(this)
    }

    override fun invoke(event: CreateHeroEvent) {
        println("Creating a custom hero: $event")

        val heroToCreate = event.toHeroDomain()
        println("Hero to create: $heroToCreate")

        customHeroUseCase.create(heroToCreate)
    }

    private fun CreateHeroEvent.toHeroDomain() = Hero(
        name = Name(name),
        age = Age(age),
        strength = Ability(strength),
        agility = Ability(agility),
        perception = Ability(perception),
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
            is Skill -> Skill(id = skill.id, level = it.level)
            is SkillNotFound -> null
        }
    }
}


