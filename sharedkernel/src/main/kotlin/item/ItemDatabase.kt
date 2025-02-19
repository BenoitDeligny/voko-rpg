package item

// Items data
class ItemDatabase {
    private val items = mutableSetOf<ItemEntity>()

    init {
        items.add(ItemEntity(id = 1, name = "Basic sword"))
        items.add(ItemEntity(id = 2, name = "Basic shield"))
    }

    fun item(id: Int): ItemEntity? = items.find { it.id == id }
}

data class ItemEntity(
    val id: Int,
    val name: String
)
