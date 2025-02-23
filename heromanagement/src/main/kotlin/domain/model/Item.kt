﻿package domain.model

sealed interface ItemResponse {
    data class Item(val id: Int, val type: ItemType) : ItemResponse
    data object ItemNotFound : ItemResponse
}

enum class ItemType {
    SHIELD,
    WEAPON
}
