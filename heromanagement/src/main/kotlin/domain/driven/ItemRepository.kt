package domain.driven

import domain.model.ItemResponse
import domain.model.ItemResponse.Item
import domain.model.ItemResponse.Weapon

interface ItemRepository {
    fun find(item: Item): ItemResponse
    fun starterOneHandedWeapons(): List<Weapon>
    fun starterTwoHandedWeapons(): List<Weapon>
    fun starterLightWeapons(): List<Weapon>
}
