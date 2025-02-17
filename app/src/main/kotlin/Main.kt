import event.Event
import event.Event.CreateHeroEvent.ItemEvent
import event.Event.CreateHeroEvent.SkillEvent
import event.SimpleEventBus
import exposition.CreateHeroHandler

fun main() {
    println("Hello and welcome in a Very Old Kind Of RPG!")

    // TODO: remove this
    // this is for example and simulation of event bus
    val eventBus = SimpleEventBus<Event>()
    val createHeroHandler = CreateHeroHandler()

    val createHeroEvent = Event.CreateHeroEvent(
        name = "Arthur",
        age = 18,
        strength = 8,
        agility = 6,
        perception = 7,
        inventory = listOf(ItemEvent(id = 1), ItemEvent(id = 2), ItemEvent(id = 3)),
        skills = listOf(
            SkillEvent(id = 1, level = 1), SkillEvent(id = 2, level = 2), SkillEvent(id = 3, level = 3)
        )
    )

    createHeroHandler.invoke(createHeroEvent)
    eventBus.publish(createHeroEvent)
}