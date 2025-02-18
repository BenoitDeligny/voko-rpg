package infrastructure

import domain.SkillResponse
import domain.SkillResponse.Skill
import domain.SkillResponse.SkillNotFound
import domain.driven.SkillRepository
import skill.SkillDatabase

class InMemorySkillRepository : SkillRepository {
    private val database = SkillDatabase()

    override fun getSkill(id: Int): SkillResponse = when (val entity = database.getSkill(id)) {
        null -> SkillNotFound
        else -> Skill(id = entity.id)
    }
}
