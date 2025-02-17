package domain.driven

import domain.Item

interface ItemRepository {
    fun getItem(id: Int): Item
    fun getItems(ids: List<Int>): List<Item>
}