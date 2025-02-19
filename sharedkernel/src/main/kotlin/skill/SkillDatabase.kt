package skill

// Skills data
class SkillDatabase {
    private val skills = mutableSetOf<SkillEntity>()

    init {
        skills.add(SkillEntity(id = 1, name = "Acrobatics"))
        skills.add(SkillEntity(id = 2, name = "Climbing"))
        skills.add(SkillEntity(id = 3, name = "Demining"))
        skills.add(SkillEntity(id = 4, name = "Fencing"))
        skills.add(SkillEntity(id = 5, name = "FirstAid"))
        skills.add(SkillEntity(id = 6, name = "LockPicking"))
        skills.add(SkillEntity(id = 7, name = "Mechanics"))
        skills.add(SkillEntity(id = 8, name = "Observation"))
        skills.add(SkillEntity(id = 9, name = "Piloting"))
        skills.add(SkillEntity(id = 10, name = "Shooting"))
        skills.add(SkillEntity(id = 11, name = "Sports"))
        skills.add(SkillEntity(id = 12, name = "Stealth"))
        skills.add(SkillEntity(id = 13, name = "Survival"))
        skills.add(SkillEntity(id = 14, name = "Swimming"))
        skills.add(SkillEntity(id = 15, name = "Wrestling"))
    }

    fun getSkill(id: Int): SkillEntity? = skills.find { it.id == id }
    fun getSkills() = skills
}

data class SkillEntity(
    val id: Int,
    val name: String,
)
