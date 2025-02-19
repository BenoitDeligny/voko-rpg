import event.Event
import event.Event.CustomHeroEvent
import event.Event.CustomHeroEvent.*
import event.Event.RandomHeroEvent
import event.SimpleEventBus
import exposition.CreateCustomHeroHandler
import exposition.CreateRandomHeroHandler

fun main() {
    println("-----Hello and welcome in a Very Old Kind Of RPG!-----")

    // TODO: this PubSub system DOES NOT WORK
    // TODO: remove this
    // this is for example and simulation of event bus
    val eventBus = SimpleEventBus<Event>()
    val createCustomHeroHandler = CreateCustomHeroHandler()
    val createRandomHeroHandler = CreateRandomHeroHandler()

    val customHeroEvent = CustomHeroEvent(
        name = NameEvent(firstName = "Arthur", lastName = "Dent"),
        age = 18,
        strength = 8,
        agility = 6,
        perception = 7,
        inventory = listOf(ItemEvent(id = 1), ItemEvent(id = 2), ItemEvent(id = 3)),
        skills = listOf(
            SkillEvent(id = 1, level = 1), SkillEvent(id = 2, level = 2), SkillEvent(id = 3, level = 3)
        )
    )

    createCustomHeroHandler.invoke(customHeroEvent)
    eventBus.publish(customHeroEvent)

    val randomHeroEvent = RandomHeroEvent
    createRandomHeroHandler.invoke(randomHeroEvent)
    eventBus.publish(randomHeroEvent)
}
