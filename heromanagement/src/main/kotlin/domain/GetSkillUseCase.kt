package domain

import domain.driven.SkillRepository
import domain.driving.GetSkill
import infrastructure.InMemorySkillRepository

class GetSkillUseCase : GetSkill {
    private val repository: SkillRepository = InMemorySkillRepository()

    override fun getSkill(id: Int): SkillResponse {
        return repository.getSkill(id)
    }
}
