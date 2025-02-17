package domain.driven

import domain.Skill

interface SkillRepository {
    fun getSkill(id: Int): Skill
    fun getSkills(ids: List<Int>): List<Skill>
}