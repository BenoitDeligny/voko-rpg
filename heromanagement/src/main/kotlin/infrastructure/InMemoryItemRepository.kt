package infrastructure

import domain.Item
import domain.driven.ItemRepository
import item.ItemDatabase

class InMemoryItemRepository : ItemRepository {
    private val database = ItemDatabase()

    override fun getItem(id: Int): Item {
        // TODO: i don't like bang bang operator
        val entity = database.getItem(id) ?: database.getItem(0)!!

        return Item(id = entity.id, name = entity.name)
    }

    override fun getItems(ids: List<Int>): List<Item> = ids
        .mapNotNull { id -> database.getItem(id) }.map { entity ->
            Item(id = entity.id, name = entity.name)
        }
}