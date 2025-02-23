package exposition

import domain.CustomHeroUseCase
import domain.GetItemUseCase
import domain.driving.CustomHero
import domain.driving.GetItem
import domain.model.Ability.*
import domain.model.Age
import domain.model.Hero
import domain.model.ItemResponse.Item
import domain.model.ItemResponse.ItemNotFound
import domain.model.Name
import domain.model.Name.FirstName
import domain.model.Name.LastName
import domain.model.Skill.*
import domain.model.Skills
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

    // TODO: think about refactoring this
    private val getItemUseCase: GetItem = GetItemUseCase()

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
        name = Name(
            firstName = FirstName(name.firstName),
            lastName = LastName(name.lastName)
        ),
        age = Age(age),
        strength = Strength(strength),
        agility = Agility(agility),
        perception = Perception(perception),
        inventory = inventory.toItemDomain(),
        skills = skills.toSkillsDomain(),
    )

    private fun List<ItemEvent>.toItemDomain() = mapNotNull {
        when (val item = getItemUseCase.getItem(it.id)) {
            is Item -> Item(id = item.id)
            is ItemNotFound -> null
        }
    }

    private fun List<SkillEvent>.toSkillsDomain(): Skills = fold(Skills()) { skills, event ->
        when (event.name) {
            "Acrobatics" -> skills.copy(acrobatics = Acrobatics(event.level))
            "Climbing" -> skills.copy(climbing = Climbing(event.level))
            "Demining" -> skills.copy(demining = Demining(event.level))
            "Fencing" -> skills.copy(fencing = Fencing(event.level))
            "FirstAid" -> skills.copy(firstAid = FirstAid(event.level))
            "LockPicking" -> skills.copy(lockPicking = LockPicking(event.level))
            "Mechanics" -> skills.copy(mechanics = Mechanics(event.level))
            "Observation" -> skills.copy(observation = Observation(event.level))
            "Piloting" -> skills.copy(piloting = Piloting(event.level))
            "Shooting" -> skills.copy(shooting = Shooting(event.level))
            "Sports" -> skills.copy(sports = Sports(event.level))
            "Stealth" -> skills.copy(stealth = Stealth(event.level))
            "Survival" -> skills.copy(survival = Survival(event.level))
            "Swimming" -> skills.copy(swimming = Swimming(event.level))
            "Wrestling" -> skills.copy(wrestling = Wrestling(event.level))
            else -> skills
        }
    }
}


