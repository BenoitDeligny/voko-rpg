package domain.model

sealed interface ItemResponse {
    data class Item(val id: Int, val type: ItemType) : ItemResponse
    data class Weapon(val id: Int, val property: WeaponProperty) : ItemResponse
    data object ItemNotFound : ItemResponse
}

enum class ItemType {
    BOOTS,
    CONSUMABLE,
    HELMET,
    SHIELD,
    WEAPON
}

enum class WeaponProperty {
    ONE_HANDED,
    TWO_HANDED,
    LIGHT,
}
