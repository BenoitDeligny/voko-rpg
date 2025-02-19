package randomize

data class Skill(
    val name: SkillName,
    val level: Int,
)

sealed interface SkillName {
    data object Acrobatics : SkillName
    data object Climbing : SkillName
    data object Demining : SkillName
    data object Fencing : SkillName
    data object FirstAid : SkillName
    data object LockPicking : SkillName
    data object Mechanics : SkillName
    data object Observation : SkillName
    data object Piloting : SkillName
    data object Shooting : SkillName
    data object Sports : SkillName
    data object Stealth : SkillName
    data object Survival : SkillName
    data object Swimming : SkillName
    data object Wrestling : SkillName
}