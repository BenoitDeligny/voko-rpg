package infrastructure

import domain.driven.HeroRepository
import domain.model.Hero

class InMemoryHeroRepository : HeroRepository {
    private val heroes = mutableSetOf<HeroEntity>()

    override fun add(hero: Hero) {
        heroes.add(
            HeroEntity(
                name = hero.name.toString(),
                age = hero.age.value,
                strength = hero.strength.value,
                agility = hero.agility.value,
                perception = hero.perception.value,
                inventory = hero.inventory.map { ItemEntity(it.id) },
                acrobatics = AcrobaticsEntity(hero.skills.acrobatics.level),
                climbing = ClimbingEntity(hero.skills.climbing.level),
                demining = DeminingEntity(hero.skills.demining.level),
                fencing = FencingEntity(hero.skills.fencing.level),
                firstAid = FirstAidEntity(hero.skills.firstAid.level),
                lockPicking = LockPickingEntity(hero.skills.lockPicking.level),
                mechanics = MechanicsEntity(hero.skills.mechanics.level),
                observation = ObservationEntity(hero.skills.observation.level),
                piloting = PilotingEntity(hero.skills.piloting.level),
                shooting = ShootingEntity(hero.skills.shooting.level),
                sports = SportsEntity(hero.skills.sports.level),
                stealth = StealthEntity(hero.skills.stealth.level),
                survival = SurvivalEntity(hero.skills.survival.level),
                swimming = SwimmingEntity(hero.skills.swimming.level),
                wrestling = WrestlingEntity(hero.skills.wrestling.level),
            )
        )
    }
}

data class HeroEntity(
    val name: String,
    val age: Int,
    val strength: Int,
    val agility: Int,
    val perception: Int,
    val inventory: List<ItemEntity>,
    val acrobatics: AcrobaticsEntity,
    val climbing: ClimbingEntity,
    val demining: DeminingEntity,
    val fencing: FencingEntity,
    val firstAid: FirstAidEntity,
    val lockPicking: LockPickingEntity,
    val mechanics: MechanicsEntity,
    val observation: ObservationEntity,
    val piloting: PilotingEntity,
    val shooting: ShootingEntity,
    val sports: SportsEntity,
    val stealth: StealthEntity,
    val survival: SurvivalEntity,
    val swimming: SwimmingEntity,
    val wrestling: WrestlingEntity,
)

data class ItemEntity(val id: Int)

data class AcrobaticsEntity(val level: Int)
data class ClimbingEntity(val level: Int)
data class DeminingEntity(val level: Int)
data class FencingEntity(val level: Int)
data class FirstAidEntity(val level: Int)
data class LockPickingEntity(val level: Int)
data class MechanicsEntity(val level: Int)
data class ObservationEntity(val level: Int)
data class PilotingEntity(val level: Int)
data class ShootingEntity(val level: Int)
data class SportsEntity(val level: Int)
data class StealthEntity(val level: Int)
data class SurvivalEntity(val level: Int)
data class SwimmingEntity(val level: Int)
data class WrestlingEntity(val level: Int)