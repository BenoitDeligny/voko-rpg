package infrastructure

import domain.driven.ItemRepository
import domain.model.ItemResponse
import domain.model.ItemResponse.*
import domain.model.ItemType.*
import domain.model.WeaponProperty.*
import item.ItemDatabase

class InMemoryItemRepository : ItemRepository {
    private val database = ItemDatabase()

    override fun find(item: Item): ItemResponse = when (item.type) {
        BOOTS -> TODO()
        CONSUMABLE -> TODO()
        HELMET -> TODO()
        SHIELD -> database.shield(item.id)?.let { Item(id = it.id, type = item.type) } ?: ItemNotFound
        WEAPON -> database.weapon(item.id)?.let { Item(id = it.id, type = item.type) } ?: ItemNotFound
    }

    override fun starterOneHandedWeapons(): List<Weapon> = database.weapons()
        .filter { it.property == "ONE_HANDED" }
        .filter { it.isStarterItem }
        .map {
            Weapon(
                id = it.id,
                property = ONE_HANDED
            )
        }

    override fun starterTwoHandedWeapons(): List<Weapon> = database.weapons()
        .filter { it.property == "TWO_HANDED" }
        .filter { it.isStarterItem }
        .map {
            Weapon(
                id = it.id,
                property = TWO_HANDED
            )
        }

    override fun starterLightWeapons(): List<Weapon> = database.weapons()
        .filter { it.property == "LIGHT" }
        .filter { it.isStarterItem }
        .map {
            Weapon(
                id = it.id,
                property = LIGHT
            )
        }
}
