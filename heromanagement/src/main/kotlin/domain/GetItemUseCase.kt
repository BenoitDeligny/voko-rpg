package domain

import domain.driven.ItemRepository
import domain.driving.GetItem
import infrastructure.InMemoryItemRepository

class GetItemUseCase : GetItem {
    private val repository: ItemRepository = InMemoryItemRepository()

    override fun getItem(id: Int): Item {
        return repository.getItem(id)
    }

    override fun getItems(ids: List<Int>): List<Item> {
        return repository.getItems(ids)
    }
}