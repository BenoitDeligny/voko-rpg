package skill

// Skills data
class SkillDatabase {
    private val skills = mutableSetOf<SkillEntity>()

    init {
        skills.add(SkillEntity(id = 1, name = "Shooting"))
        skills.add(SkillEntity(id = 2, name = "Swimming"))
    }

    fun getSkill(id: Int): SkillEntity? = skills.find { it.id == id }
}

data class SkillEntity(
    val id: Int,
    val name: String,
)
