package exposition

import domain.*
import event.Event
import event.Event.CreateHeroEvent
import event.SimpleEventBus
import event.Subscriber
import ulid.ULID.Companion.parseULID

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
        gear = gear.toDomain(),
        inventory = inventory
            .map {
                Item(
                    id = parseULID(it.id),
                    quantity = it.quantity
                )
            },
        skills = skills
            .map {
                Skill(
                    id = parseULID(it.id),
                    level = it.level
                )
            }
    )

    private fun CreateHeroEvent.GearEvent.toDomain() = Gear(
        helmet = Item(id = parseULID(helmet.id), quantity = helmet.quantity),
        mask = Item(id = parseULID(mask.id), quantity = mask.quantity),
        necklace = Item(id = parseULID(necklace.id), quantity = necklace.quantity),
        armor = Item(id = parseULID(armor.id), quantity = armor.quantity),
        cloak = Item(id = parseULID(cloak.id), quantity = cloak.quantity),
        costume = Item(id = parseULID(costume.id), quantity = costume.quantity),
        bracers = Item(id = parseULID(bracers.id), quantity = bracers.quantity),
        gloves = Item(id = parseULID(gloves.id), quantity = gloves.quantity),
        rightRing = Item(id = parseULID(rightRing.id), quantity = rightRing.quantity),
        leftRing = Item(id = parseULID(leftRing.id), quantity = leftRing.quantity),
        belt = Item(id = parseULID(belt.id), quantity = belt.quantity),
        boots = Item(id = parseULID(boots.id), quantity = boots.quantity),
        mainHand = Item(id = parseULID(mainHand.id), quantity = mainHand.quantity),
        offHand = Item(id = parseULID(offHand.id), quantity = offHand.quantity),
    )
}


