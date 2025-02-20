package domain.driving

import domain.model.ItemResponse

interface GetItem {
    fun getItem(id: Int): ItemResponse
}
