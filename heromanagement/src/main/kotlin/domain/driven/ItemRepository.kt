package domain.driven

import domain.model.ItemResponse

interface ItemRepository {
    fun getItem(id: Int): ItemResponse
}
