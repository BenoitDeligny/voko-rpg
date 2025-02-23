package domain.model

sealed class Skill {
    open val level: Int get() = 0

    data class Acrobatics(override val level: Int) : Skill()
    data class Climbing(override val level: Int) : Skill()
    data class Demining(override val level: Int) : Skill()
    data class Fencing(override val level: Int) : Skill()
    data class FirstAid(override val level: Int) : Skill()
    data class LockPicking(override val level: Int) : Skill()
    data class Mechanics(override val level: Int) : Skill()
    data class Observation(override val level: Int) : Skill()
    data class Piloting(override val level: Int) : Skill()
    data class Shooting(override val level: Int) : Skill()
    data class Sports(override val level: Int) : Skill()
    data class Stealth(override val level: Int) : Skill()
    data class Survival(override val level: Int) : Skill()
    data class Swimming(override val level: Int) : Skill()
    data class Wrestling(override val level: Int) : Skill()
}
