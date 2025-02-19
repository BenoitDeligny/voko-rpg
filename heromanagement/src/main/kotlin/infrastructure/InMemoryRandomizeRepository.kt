package infrastructure

import domain.Ability
import domain.Ability.*
import domain.Age
import domain.ItemResponse.Item
import domain.Name
import domain.SkillName.*
import domain.SkillResponse.Skill
import domain.driven.RandomizeRepository
import randomize.TheRandomizer
import randomize.AbilityName.Agility as AgilityFromRandomizer
import randomize.AbilityName.Perception as PerceptionFromRandomizer
import randomize.AbilityName.Strength as StrengthFromRandomizer
import randomize.SkillName.Acrobatics as AcrobaticsFromRandomizer
import randomize.SkillName.Climbing as ClimbingFromRandomizer
import randomize.SkillName.Demining as DeminingFromRandomizer
import randomize.SkillName.Fencing as FencingFromRandomizer
import randomize.SkillName.FirstAid as FirstAidFromRandomizer
import randomize.SkillName.LockPicking as LockPickingFromRandomizer
import randomize.SkillName.Mechanics as MechanicsFromRandomizer
import randomize.SkillName.Observation as ObservationFromRandomizer
import randomize.SkillName.Piloting as PilotingFromRandomizer
import randomize.SkillName.Shooting as ShootingFromRandomizer
import randomize.SkillName.Sports as SportsFromRandomizer
import randomize.SkillName.Stealth as StealthFromRandomizer
import randomize.SkillName.Survival as SurvivalFromRandomizer
import randomize.SkillName.Swimming as SwimmingFromRandomizer
import randomize.SkillName.Wrestling as WrestlingFromRandomizer

class InMemoryRandomizeRepository : RandomizeRepository {
    private val randomizer = TheRandomizer()

    override fun randomizeName(): Name = randomizer.randomizeName()
        .let { Name(firstName = it.firstName, lastName = it.lastName) }

    override fun randomizeAge(): Age = Age(randomizer.randomizeAge())

    override fun randomizeAbilities(): List<Ability> = randomizer.randomizeAbilities()
        .map {
            when (it.name) {
                StrengthFromRandomizer -> Strength(it.value)
                AgilityFromRandomizer -> Agility(it.value)
                PerceptionFromRandomizer -> Perception(it.value)
            }
        }

    override fun randomizeSkills(): List<Skill> = randomizer.randomizeSkills()
        .map {
            Skill(
                name = when (it.name) {
                    AcrobaticsFromRandomizer -> Acrobatics
                    ClimbingFromRandomizer -> Climbing
                    DeminingFromRandomizer -> Demining
                    FencingFromRandomizer -> Fencing
                    FirstAidFromRandomizer -> FirstAid
                    LockPickingFromRandomizer -> LockPicking
                    MechanicsFromRandomizer -> Mechanics
                    ObservationFromRandomizer -> Observation
                    PilotingFromRandomizer -> Piloting
                    ShootingFromRandomizer -> Shooting
                    SportsFromRandomizer -> Sports
                    StealthFromRandomizer -> Stealth
                    SurvivalFromRandomizer -> Survival
                    SwimmingFromRandomizer -> Swimming
                    WrestlingFromRandomizer -> Wrestling
                },
                level = it.level
            )
        }

    override fun randomizeInventory(): List<Item> {
        TODO("Not yet implemented")
    }
}
