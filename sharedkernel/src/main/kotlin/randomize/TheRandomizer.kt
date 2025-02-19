package randomize

class TheRandomizer {
    fun randomizeName() {
        println("Randomizing name")
        val firstName = firstNames.random()
        val lastName = lastNames.random()
    }

    fun randomizeAge() {
        println("Randomizing age")
        val age = (15..20).random()
    }

    fun randomizeAbilities() {
        println("Randomizing abilities")
    }

    fun randomizeInventory() {
        println("Randomizing inventory")
    }

    fun randomizeSkills() {
        println("Randomizing skills")
    }
}
