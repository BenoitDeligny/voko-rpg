package domain.driving

import domain.model.ItemResponse
import domain.model.ItemResponse.Item

interface GetItem {
    fun getItem(item: Item): ItemResponse
}
