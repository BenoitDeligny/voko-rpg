package domain.model

sealed class Skill {
    data class Acrobatics(val level: Int = 0) : Skill()
    data class Climbing(val level: Int = 0) : Skill()
    data class Demining(val level: Int = 0) : Skill()
    data class Fencing(val level: Int = 0) : Skill()
    data class FirstAid(val level: Int = 0) : Skill()
    data class LockPicking(val level: Int = 0) : Skill()
    data class Mechanics(val level: Int = 0) : Skill()
    data class Observation(val level: Int = 0) : Skill()
    data class Piloting(val level: Int = 0) : Skill()
    data class Shooting(val level: Int = 0) : Skill()
    data class Sports(val level: Int = 0) : Skill()
    data class Stealth(val level: Int = 0) : Skill()
    data class Survival(val level: Int = 0) : Skill()
    data class Swimming(val level: Int = 0) : Skill()
    data class Wrestling(val level: Int = 0) : Skill()

    data object SkillNotFound : Skill()
}