package exposition

import domain.*
import event.Event
import event.Event.RandomHeroEvent
import event.SimpleEventBus
import event.Subscriber

// TODO: as of today, this is a placeholder
// but for now it "replace" a classic controller

// TODO: use dependency injection here
// TODO: add tests
class CreateRandomHeroHandler : Subscriber<RandomHeroEvent> {
    private val eventBus = SimpleEventBus<Event>()
    private val randomHeroUseCase = RandomHeroUseCase()

    init {
        eventBus.register(this)
    }

    override fun invoke(event: RandomHeroEvent) {
        println("Creating a random hero: $event")
    }
}


