package infrastructure

import domain.SkillName.*
import domain.SkillResponse
import domain.SkillResponse.Skill
import domain.SkillResponse.SkillNotFound
import domain.driven.SkillRepository
import skill.SkillDatabase

class InMemorySkillRepository : SkillRepository {
    private val database = SkillDatabase()

    override fun getSkill(id: Int): SkillResponse = when (val entity = database.getSkill(id)) {
        null -> SkillNotFound
        else -> when (entity.name) {
            "Acrobatics" -> Skill(Acrobatics)
            "Climbing" -> Skill(Climbing)
            "Demining" -> Skill(Demining)
            "Fencing" -> Skill(Fencing)
            "FirstAid" -> Skill(FirstAid)
            "LockPicking" -> Skill(LockPicking)
            "Mechanics" -> Skill(Mechanics)
            "Observation" -> Skill(Observation)
            "Piloting" -> Skill(Piloting)
            "Shooting" -> Skill(Shooting)
            "Sports" -> Skill(Sports)
            "Stealth" -> Skill(Stealth)
            "Survival" -> Skill(Survival)
            "Swimming" -> Skill(Swimming)
            "Wrestling" -> Skill(Wrestling)
            else -> SkillNotFound
        }
    }
}
