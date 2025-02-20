package domain

import domain.driven.SkillRepository
import domain.driving.GetSkill
import domain.model.Skill
import infrastructure.InMemorySkillRepository

class GetSkillUseCase : GetSkill {
    private val repository: SkillRepository = InMemorySkillRepository()

    override fun getSkill(id: Int): Skill {
        return repository.skill(id)
    }
}
