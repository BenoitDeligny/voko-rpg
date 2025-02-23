package item

// Items data
class ItemDatabase {
    private val weapons = mutableSetOf<WeaponEntity>()
    private val shields = mutableSetOf<ShieldEntity>()

    init {
        weapons.addAll(
            listOf(
                WeaponEntity(
                    id = 0,
                    name = "Broomstick",
                    damages = 0,
                    powerBonus = 0,
                    protectionBonus = 0,
                    damagesBonus = 0,
                ),
                WeaponEntity(
                    id = 1,
                    name = "Basic sword",
                    damages = 1,
                    powerBonus = 0,
                    protectionBonus = 0,
                    damagesBonus = 0,
                )
            )
        )
        shields.addAll(
            listOf(
                ShieldEntity(
                    id = 0,
                    name = "Bin cover",
                    protection = 1,
                    powerBonus = 0,
                    protectionBonus = 0,
                    damagesBonus = 0,
                ),
                ShieldEntity(
                    id = 1,
                    name = "Basic shield",
                    protection = 1,
                    powerBonus = 0,
                    protectionBonus = 0,
                    damagesBonus = 0,
                )
            )
        )
    }

    fun weapon(id: Int): WeaponEntity? = weapons.find { it.id == id }
    fun shield(id: Int): ShieldEntity? = shields.find { it.id == id }
}

data class WeaponEntity(
    val id: Int,
    val name: String,
    val damages: Int,
    val powerBonus: Int,
    val protectionBonus: Int,
    val damagesBonus: Int,
)

data class ShieldEntity(
    val id: Int,
    val name: String,
    val protection: Int,
    val powerBonus: Int,
    val protectionBonus: Int,
    val damagesBonus: Int,
)
