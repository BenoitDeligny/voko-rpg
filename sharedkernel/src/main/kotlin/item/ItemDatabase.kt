package item

import ulid.ULID
import ulid.ULID.Companion.parseULID

// Items data
class ItemDatabase {
    private val items = mutableMapOf<String, ItemEntity>()

    init {
        items["empty"] = ItemEntity(
            id = parseULID("empty"),
            name = "empty",
            powerBonus = 0,
            damageBonus = 0,
            protectionBonus = 0
        )
        items["basicSword"] = ItemEntity(
            id = parseULID("basicSword"),
            name = "Basic sword",
            powerBonus = 0,
            damageBonus = 1,
            protectionBonus = 0
        )
        items["basicShield"] = ItemEntity(
            id = parseULID("basicShield"),
            name = "Basic shield",
            powerBonus = 0,
            damageBonus = 0,
            protectionBonus = 1
        )
    }

    fun getItem(id: ULID): ItemEntity {
        return items[id.toString()] ?: items["empty"]!!
    }
}

data class ItemEntity(
    val id: ULID,
    val name: String,
    val powerBonus: Int,
    val damageBonus: Int,
    val protectionBonus: Int,
)
