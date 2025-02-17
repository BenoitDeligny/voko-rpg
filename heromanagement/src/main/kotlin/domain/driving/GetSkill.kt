package domain.driving

import domain.Skill

interface GetSkill {
    fun getSkill(id: Int): Skill
    fun getSkills(ids: List<Int>): List<Skill>
}