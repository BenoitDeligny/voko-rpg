package exposition

import domain.*
import domain.driving.CustomHero
import domain.driving.GetItem
import domain.driving.GetSkill
import event.Event
import event.Event.CreateHeroEvent
import event.SimpleEventBus
import event.Subscriber

// TODO: as of today, this is a placeholder
// Maybe this is something that will be in DOMAIN
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

        val items = getItemUseCase.getItems(event.inventory.map { it.id })
        val skills = event.skills.map { Skill(getSkillUseCase.getSkill(it.id).id, it.level) }

        val heroToCreate = event.toDomain(items = items, skills = skills)
        println("Hero to create: $heroToCreate")

        customHeroUseCase.create(heroToCreate)
    }

    private fun CreateHeroEvent.toDomain(items: List<Item>, skills: List<Skill>) = Hero(
        name = Name(name),
        age = Age(age),
        strength = Ability(strength),
        agility = Ability(agility),
        perception = Ability(perception),
        inventory = items,
        skills = skills,
    )
}


