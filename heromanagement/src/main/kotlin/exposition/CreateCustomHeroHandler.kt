package exposition

import domain.CustomHeroUseCase
import domain.ItemsService
import domain.driving.CustomHero
import domain.driving.Items
import domain.model.Ability.*
import domain.model.Age
import domain.model.Hero
import domain.model.ItemResponse.Item
import domain.model.ItemResponse.ItemNotFound
import domain.model.ItemType.SHIELD
import domain.model.ItemType.WEAPON
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

// as of today, this is a placeholder
// but for now it "replace" a classic controller

// use dependency injection here
// add tests
class CreateCustomHeroHandler : Subscriber<CustomHeroEvent> {
    private val eventBus = SimpleEventBus<Event>()
    private val customHeroUseCase: CustomHero = CustomHeroUseCase()
    private val itemsService: Items = ItemsService()

    init {
        eventBus.register(this)
    }

    override fun invoke(event: CustomHeroEvent) {
        println("Creating a custom hero: $event")

        val hero = event.toHero()
        println("Hero to create: $hero")

        customHeroUseCase.create(hero)
    }

    private fun CustomHeroEvent.toHero() = Hero(
        name = Name(
            firstName = FirstName(name.firstName),
            lastName = LastName(name.lastName)
        ),
        age = Age(age),
        strength = Strength(strength),
        agility = Agility(agility),
        perception = Perception(perception),
        inventory = inventory.toItem(),
        skills = skills.toSkills(),
    )

    private fun List<ItemEvent>.toItem() = mapNotNull { itemEvent ->
        when (itemEvent.type) {
            "Weapon" -> Item(id = itemEvent.id, type = WEAPON)
            "Shield" -> Item(id = itemEvent.id, type = SHIELD)
            else -> null
        }?.let { item ->
            when (itemsService.find(item)) {
                is Item -> item
                is ItemNotFound -> null
            }
        }
    }

    private fun List<SkillEvent>.toSkills(): Skills = fold(Skills()) { skills, event ->
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


