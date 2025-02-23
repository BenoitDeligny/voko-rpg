package domain

import domain.driven.ItemRepository
import domain.driving.Items
import domain.model.ItemResponse
import domain.model.ItemResponse.Item
import infrastructure.InMemoryItemRepository

// Domain service ? Not very nice but how to do better ?
class ItemsService : Items {
    private val repository: ItemRepository = InMemoryItemRepository()

    override fun find(item: Item): ItemResponse {
        return repository.find(item)
    }
}
