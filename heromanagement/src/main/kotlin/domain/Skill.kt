package domain

sealed interface SkillResponse {
    data class Skill(val id: Int, val level: Int = 0) : SkillResponse
    data object SkillNotFound : SkillResponse
}
