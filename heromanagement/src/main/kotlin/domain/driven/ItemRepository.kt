package domain.driven

import domain.model.ItemResponse
import domain.model.ItemResponse.Item

interface ItemRepository {
    fun getItem(item: Item): ItemResponse
}
