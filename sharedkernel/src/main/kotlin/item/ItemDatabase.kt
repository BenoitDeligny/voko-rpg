package item

// Items data
class ItemDatabase {
    private val shields = mutableSetOf<ShieldEntity>()
    private val weapons = mutableSetOf<WeaponEntity>()

    init {
        shields.addAll(
            listOf(
                ShieldEntity(
                    id = 0,
                    name = "Bin cover",
                    protection = 1,
                    powerBonus = 0,
                    protectionBonus = 0,
                    damagesBonus = 0,
                    isStarterItem = true
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
                    property = "one-handed",
                    damages = 0,
                    powerBonus = 0,
                    protectionBonus = 0,
                    damagesBonus = 0,
                    isStarterItem = true,
                ),
                WeaponEntity(
                    id = 1,
                    name = "Shovel",
                    property = "TWO_HANDED",
                    damages = 0,
                    powerBonus = 0,
                    protectionBonus = 0,
                    damagesBonus = 0,
                    isStarterItem = true,
                ),
                WeaponEntity(
                    id = 2,
                    name = "Basic sword",
                    property = "ONE_HANDED",
                    damages = 1,
                    powerBonus = 0,
                    protectionBonus = 0,
                    damagesBonus = 0,
                ),
                WeaponEntity(
                    id = 3,
                    name = "Dagger",
                    property = "LIGHT",
                    damages = 2,
                    powerBonus = 0,
                    protectionBonus = 0,
                    damagesBonus = 0,
                    isStarterItem = true,
                )
            )
        )
    }

    fun shield(id: Int): ShieldEntity? = shields.find { it.id == id }
    fun shields(): List<ShieldEntity> = shields.toList()
    fun weapon(id: Int): WeaponEntity? = weapons.find { it.id == id }
    fun weapons(): List<WeaponEntity> = weapons.toList()
}

data class ShieldEntity(
    val id: Int,
    val name: String,
    val protection: Int,
    val powerBonus: Int,
    val protectionBonus: Int,
    val damagesBonus: Int,
    val isStarterItem: Boolean = false,
)

data class WeaponEntity(
    val id: Int,
    val name: String,
    val property: String,
    val damages: Int,
    val powerBonus: Int,
    val protectionBonus: Int,
    val damagesBonus: Int,
    val isStarterItem: Boolean = false,
)
