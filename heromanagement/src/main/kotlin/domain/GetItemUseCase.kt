package domain

import domain.driven.ItemRepository
import domain.driving.GetItem
import domain.model.ItemResponse
import domain.model.ItemResponse.Item
import infrastructure.InMemoryItemRepository

class GetItemUseCase : GetItem {
    private val repository: ItemRepository = InMemoryItemRepository()

    override fun getItem(item: Item): ItemResponse {
        return repository.getItem(item)
    }
}
