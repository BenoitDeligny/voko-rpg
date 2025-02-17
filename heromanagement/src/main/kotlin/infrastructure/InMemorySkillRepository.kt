package infrastructure

import domain.Skill
import domain.driven.SkillRepository
import skill.SkillDatabase

class InMemorySkillRepository : SkillRepository {
    private val database = SkillDatabase()

    override fun getSkill(id: Int): Skill {
        // TODO: i don't like bang bang operator
        val entity = database.getSkill(id) ?: database.getSkill(id = 0)!!

        return Skill(id = entity.id)
    }

    override fun getSkills(ids: List<Int>): List<Skill> = ids
        .mapNotNull { id -> database.getSkill(id) }.map { entity ->
            Skill(id = entity.id)
        }
}