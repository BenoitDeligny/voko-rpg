package domain

sealed interface ItemResponse {
    data class Item(val id: Int, val name: String) : ItemResponse
    data object ItemNotFound : ItemResponse
}
