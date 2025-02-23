package domain.driving

import domain.model.ItemResponse
import domain.model.ItemResponse.Item

interface Items {
    fun find(item: Item): ItemResponse
}
