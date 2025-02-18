package item

// Items data
class ItemDatabase {
    private val items = mutableSetOf<ItemEntity>()

    init {
        items.add(ItemEntity(id = 1, name = "Basic sword", powerBonus = 0, damageBonus = 1, protectionBonus = 0))
        items.add(ItemEntity(id = 2, name = "Basic shield", powerBonus = 0, damageBonus = 0, protectionBonus = 1))
    }

    fun item(id: Int): ItemEntity? = items.find { it.id == id }
}

data class ItemEntity(
    val id: Int,
    val name: String,
    val powerBonus: Int,
    val damageBonus: Int,
    val protectionBonus: Int,
)
