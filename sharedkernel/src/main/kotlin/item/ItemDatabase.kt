package item

// Items data
class ItemDatabase {
    private val starterItems = mutableSetOf<StarterItemsEntity>()
    private val shields = mutableSetOf<ShieldEntity>()
    private val weapons = mutableSetOf<WeaponEntity>()

    init {
        starterItems.addAll(
            listOf(
                StarterItemsEntity(
                    id = 0,
                    name = "Broomstick",
                    type = "weapon",
                    damages = 1,
                    protection = 0,
                ),
                StarterItemsEntity(
                    id = 1,
                    name = "Bin cover",
                    type = "shield",
                    damages = 0,
                    protection = 0,
                ),
                StarterItemsEntity(
                    id = 2,
                    name = "Crocs",
                    type = "boots",
                    damages = 0,
                    protection = 0,
                ),
                StarterItemsEntity(
                    id = 4,
                    name = "Straw hat",
                    type = "helmet",
                    damages = 0,
                    protection = 0,
                ),
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
    }

    fun starterItems(): List<StarterItemsEntity> = starterItems.toList()
    fun shield(id: Int): ShieldEntity? = shields.find { it.id == id }
    fun weapon(id: Int): WeaponEntity? = weapons.find { it.id == id }
}

data class StarterItemsEntity(
    val id: Int,
    val name: String,
    val type: String,
    val damages: Int,
    val protection: Int,
)

data class ShieldEntity(
    val id: Int,
    val name: String,
    val protection: Int,
    val powerBonus: Int,
    val protectionBonus: Int,
    val damagesBonus: Int,
)

data class WeaponEntity(
    val id: Int,
    val name: String,
    val damages: Int,
    val powerBonus: Int,
    val protectionBonus: Int,
    val damagesBonus: Int,
)
