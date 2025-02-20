package domain.driven

import domain.model.Skill

interface SkillRepository {
    fun skill(id: Int): Skill
    fun skills(): List<Skill>
}
