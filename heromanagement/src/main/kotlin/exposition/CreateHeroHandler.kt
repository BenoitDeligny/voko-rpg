package exposition

import Event
import Event.CreateHeroEvent
import SimpleEventBus
import Subscriber
import domain.*

// TODO: as of today, this is a placeholder
// Maybe this is something that will be in DOMAIN
// but for now it "replace" a classic controller

// TODO: use dependency injection here
// TODO: add tests
class CreateHeroHandler : Subscriber<CreateHeroEvent> {
    private val eventBus = SimpleEventBus<Event>()
    private val useCase = CustomHeroUseCase()

    init {
        eventBus.register(this)
    }

    override fun invoke(event: CreateHeroEvent) {
        println("HeroController received event: $event")
        val heroToCreate = event.toDomain()
        useCase.create(heroToCreate)
    }

    private fun CreateHeroEvent.toDomain() = Hero(
        name = Name(name),
        age = Age(age),
        strength = Ability(strength),
        agility = Ability(agility),
        perception = Ability(perception),
    )
}


