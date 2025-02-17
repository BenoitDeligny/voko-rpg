import event.Event
import event.SimpleEventBus
import exposition.CreateHeroHandler

fun main() {
    println("Hello and welcome in a Very Old Kind Of RPG!")

    // TODO: remove this
    // this is for example and simulation of event bus
    val eventBus = SimpleEventBus<Event>()
    val createHeroHandler = CreateHeroHandler()
    val createHeroEvent = Event.CreateHeroEvent(name = "Arthur", age = 18, strength = 8, agility = 6, perception = 7)
    createHeroHandler.invoke(createHeroEvent)
    eventBus.publish(createHeroEvent)
}