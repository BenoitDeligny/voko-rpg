package domain.driven

import domain.model.ItemResponse
import domain.model.ItemResponse.Item

interface ItemRepository {
    fun find(item: Item): ItemResponse
    fun starterItems(): List<ItemResponse>
}
