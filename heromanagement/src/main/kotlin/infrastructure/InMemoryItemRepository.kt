package infrastructure

import domain.driven.ItemRepository
import domain.model.ItemResponse
import domain.model.ItemResponse.Item
import domain.model.ItemResponse.ItemNotFound
import domain.model.ItemType.*
import item.ItemDatabase

class InMemoryItemRepository : ItemRepository {
    private val database = ItemDatabase()

    override fun find(item: Item): ItemResponse = when (item.type) {
        BOOTS -> TODO()
        HELMET -> TODO()
        SHIELD -> database.shield(item.id)?.let { Item(id = it.id, type = item.type) } ?: ItemNotFound
        WEAPON -> database.weapon(item.id)?.let { Item(id = it.id, type = item.type) } ?: ItemNotFound
    }

    override fun starterItems(): List<ItemResponse> = database.starterItems()
        .map {
            when (it.type) {
                "boots" -> Item(id = it.id, type = BOOTS)
                "helmet" -> Item(id = it.id, type = HELMET)
                "shield" -> Item(id = it.id, type = SHIELD)
                "weapon" -> Item(id = it.id, type = WEAPON)
                else -> ItemNotFound
            }
        }
}
