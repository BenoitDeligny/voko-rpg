package domain.driving

import domain.SkillResponse

interface GetSkill {
    fun getSkill(id: Int): SkillResponse
}
