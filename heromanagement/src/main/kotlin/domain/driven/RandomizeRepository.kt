package domain.driven

import domain.*

interface RandomizeRepository {
    fun randomizeName(): Name
    fun randomizeAge(): Age
    fun randomizeAbilities(): List<Ability>
    fun randomizeSkills(): List<SkillResponse.Skill>
    fun randomizeInventory(): List<ItemResponse.Item>
}
