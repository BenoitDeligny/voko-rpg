package skill

// Skills data
class SkillDatabase {
    private val skills = mutableSetOf<SkillEntity>()

    init {
        skills.add(SkillEntity(id = 1, name = "Acrobatie"))
        skills.add(SkillEntity(id = 2, name = "Crochetage"))
        skills.add(SkillEntity(id = 3, name = "Déminage"))
        skills.add(SkillEntity(id = 4, name = "Discretion"))
        skills.add(SkillEntity(id = 5, name = "Escalade"))
        skills.add(SkillEntity(id = 6, name = "Escrime"))
        skills.add(SkillEntity(id = 7, name = "Lutte"))
        skills.add(SkillEntity(id = 8, name = "Natation"))
        skills.add(SkillEntity(id = 9, name = "Observation"))
        skills.add(SkillEntity(id = 10, name = "Pilotage"))
        skills.add(SkillEntity(id = 11, name = "Premier soins"))
        skills.add(SkillEntity(id = 12, name = "Réparation"))
        skills.add(SkillEntity(id = 13, name = "Sport"))
        skills.add(SkillEntity(id = 14, name = "Survie"))
        skills.add(SkillEntity(id = 15, name = "Tir"))
    }

    fun getSkill(id: Int): SkillEntity? = skills.find { it.id == id }
    fun getSkills() = skills
}

data class SkillEntity(
    val id: Int,
    val name: String,
)
