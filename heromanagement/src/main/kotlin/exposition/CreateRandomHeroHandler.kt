package exposition

import domain.RandomHeroUseCase
import domain.driving.RandomHero
import event.Event
import event.Event.RandomHeroEvent
import event.SimpleEventBus
import event.Subscriber

// as of today, this is a placeholder
// but for now it "replace" a classic controller

// use dependency injection here
// add tests
class CreateRandomHeroHandler : Subscriber<RandomHeroEvent> {
    private val eventBus = SimpleEventBus<Event>()
    private val randomHeroUseCase: RandomHero = RandomHeroUseCase()

    init {
        eventBus.register(this)
    }

    override fun invoke(event: RandomHeroEvent) {
        println("Creating a random hero: $event")

        randomHeroUseCase.create()
    }
}


