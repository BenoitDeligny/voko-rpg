package infrastructure

import domain.model.ItemResponse
import domain.model.ItemResponse.Item
import domain.model.ItemResponse.ItemNotFound
import domain.driven.ItemRepository
import item.ItemDatabase

class InMemoryItemRepository : ItemRepository {
    private val database = ItemDatabase()

    override fun getItem(id: Int): ItemResponse = when (val entity = database.item(id)) {
        null -> ItemNotFound
        else -> Item(id = entity.id, name = entity.name)
    }
}
