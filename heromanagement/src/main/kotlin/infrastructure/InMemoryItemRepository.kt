package infrastructure

import domain.ItemResponse
import domain.ItemResponse.Item
import domain.ItemResponse.ItemNotFound
import domain.driven.ItemRepository
import item.ItemDatabase

class InMemoryItemRepository : ItemRepository {
    private val database = ItemDatabase()

    override fun getItem(id: Int): ItemResponse = when (val entity = database.item(id)) {
        null -> ItemNotFound
        else -> Item(id = entity.id, name = entity.name)
    }
}
