package domain.model

sealed interface ItemResponse {
    data class Item(val id: Int) : ItemResponse
    data object ItemNotFound : ItemResponse
}
