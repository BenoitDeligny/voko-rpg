package domain.driving

import domain.ItemResponse

interface GetItem {
    fun getItem(id: Int): ItemResponse
}
