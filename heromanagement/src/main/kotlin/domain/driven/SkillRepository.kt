package domain.driven

import domain.SkillResponse

interface SkillRepository {
    fun getSkill(id: Int): SkillResponse
}
