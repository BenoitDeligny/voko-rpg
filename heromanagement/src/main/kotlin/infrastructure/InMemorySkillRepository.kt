package infrastructure

import domain.model.Skill
import domain.model.Skill.*
import domain.driven.SkillRepository
import skill.SkillDatabase
import skill.SkillDatabase.SkillEntity

class InMemorySkillRepository : SkillRepository {
    private val database = SkillDatabase()

    override fun skill(id: Int): Skill = when (val entity = database.skill(id)) {
        null -> SkillNotFound
        else -> entity.toSkill()
    }

    override fun skills(): List<Skill> = database.skills().map { it.toSkill() }

    private fun SkillEntity.toSkill(): Skill = when (name) {
        "Acrobatics" -> Acrobatics()
        "Climbing" -> Climbing()
        "Demining" -> Demining()
        "Fencing" -> Fencing()
        "FirstAid" -> FirstAid()
        "LockPicking" -> LockPicking()
        "Mechanics" -> Mechanics()
        "Observation" -> Observation()
        "Piloting" -> Piloting()
        "Shooting" -> Shooting()
        "Sports" -> Sports()
        "Stealth" -> Stealth()
        "Survival" -> Survival()
        "Swimming" -> Swimming()
        "Wrestling" -> Wrestling()
        else -> SkillNotFound
    }
}
