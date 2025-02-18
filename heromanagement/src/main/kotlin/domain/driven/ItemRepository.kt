package domain.driven

import domain.ItemResponse

interface ItemRepository {
    fun getItem(id: Int): ItemResponse
}
