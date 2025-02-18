package domain

import domain.driven.ItemRepository
import domain.driving.GetItem
import infrastructure.InMemoryItemRepository

class GetItemUseCase : GetItem {
    private val repository: ItemRepository = InMemoryItemRepository()

    override fun getItem(id: Int): ItemResponse {
        return repository.getItem(id)
    }
}
