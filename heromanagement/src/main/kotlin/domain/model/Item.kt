﻿package domain.model

sealed interface ItemResponse {
    data class Item(val id: Int, val name: String) : ItemResponse
    data object ItemNotFound : ItemResponse
}

@JvmInline
value class ItemBis(val id: Int)
