package domain.driving

import domain.Item

interface GetItem {
    fun getItem(id: Int): Item
    fun getItems(ids: List<Int>): List<Item>
}