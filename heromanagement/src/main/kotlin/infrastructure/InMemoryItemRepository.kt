package infrastructure

import domain.driven.ItemRepository
import domain.model.ItemResponse
import domain.model.ItemResponse.Item
import domain.model.ItemResponse.ItemNotFound
import domain.model.ItemType.SHIELD
import domain.model.ItemType.WEAPON
import item.ItemDatabase

class InMemoryItemRepository : ItemRepository {
    private val database = ItemDatabase()

    override fun getItem(item: Item): ItemResponse = when (item.type) {
        WEAPON -> database.weapon(item.id)?.let { Item(id = it.id, type = item.type) } ?: ItemNotFound
        SHIELD -> database.shield(item.id)?.let { Item(id = it.id, type = item.type) } ?: ItemNotFound
    }
}
