package domain

import domain.driven.SkillRepository
import domain.driving.GetSkill
import infrastructure.InMemorySkillRepository

class GetSkillUseCase : GetSkill {
    private val repository: SkillRepository = InMemorySkillRepository()

    override fun getSkill(id: Int): Skill {
        return repository.getSkill(id)
    }

    override fun getSkills(ids: List<Int>): List<Skill> {
        return repository.getSkills(ids)
    }
}