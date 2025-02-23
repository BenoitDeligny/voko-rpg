package domain.model

import domain.model.Skill.*

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

data class Skills(
    val acrobatics: Acrobatics = Acrobatics(0),
    val climbing: Climbing = Climbing(0),
    val demining: Demining = Demining(0),
    val fencing: Fencing = Fencing(0),
    val firstAid: FirstAid = FirstAid(0),
    val lockPicking: LockPicking = LockPicking(0),
    val mechanics: Mechanics = Mechanics(0),
    val observation: Observation = Observation(0),
    val piloting: Piloting = Piloting(0),
    val shooting: Shooting = Shooting(0),
    val sports: Sports = Sports(0),
    val stealth: Stealth = Stealth(0),
    val survival: Survival = Survival(0),
    val swimming: Swimming = Swimming(0),
    val wrestling: Wrestling = Wrestling(0),
) {
    companion object {
        val skills = listOf(
            "Acrobatics",
            "Climbing",
            "Demining",
            "Fencing",
            "FirstAid",
            "LockPicking",
            "Mechanics",
            "Observation",
            "Piloting",
            "Shooting",
            "Sports",
            "Stealth",
            "Survival",
            "Swimming",
            "Wrestling"
        )
    }
}
