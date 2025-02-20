package domain.driving

import domain.model.Skill

interface GetSkill {
    fun getSkill(id: Int): Skill
}
