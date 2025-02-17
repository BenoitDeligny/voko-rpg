package item

import item.Enhancements.Companion.NONE
import ulid.ULID

sealed class Item(
    open val id: ULID = ULID.nextULID(),
    // TODO: is it this or a Map<EnhancementType, Int> ? Or a Set ? A List ?
    open val enhancements: Enhancements = NONE,
) {

    data class Armor(
        override val id: ULID = ULID.nextULID(),
        override val enhancements: Enhancements = NONE,
        val protection: Int = 0,
    ) : Item(id = id, enhancements = enhancements) {
        companion object {
            // TODO: change this --> Item() is NOT the same as Empty()
            val emptySlot = Armor()
        }
    }

    data class Belt(
        override val id: ULID = ULID.nextULID(),
        override val enhancements: Enhancements = NONE,
    ) : Item(id = id, enhancements = enhancements) {
        companion object {
            val emptySlot = Belt()
        }
    }

    data class Boots(
        override val id: ULID = ULID.nextULID(),
        override val enhancements: Enhancements = NONE,
        val protection: Int = 0,
    ) : Item(id = id, enhancements = enhancements) {
        companion object {
            val emptySlot = Boots()
        }
    }

    data class Bracers(
        override val id: ULID = ULID.nextULID(),
        override val enhancements: Enhancements = NONE,
    ) : Item(id = id, enhancements = enhancements) {
        companion object {
            val emptySlot = Bracers()
        }
    }

    data class Cloak(
        override val id: ULID = ULID.nextULID(),
        override val enhancements: Enhancements = NONE,
    ) : Item(id = id, enhancements = enhancements) {
        companion object {
            val emptySlot = Cloak()
        }
    }

    data class Costume(
        override val id: ULID = ULID.nextULID(),
        override val enhancements: Enhancements = NONE,
    ) : Item(id = id, enhancements = enhancements) {
        companion object {
            val emptySlot = Costume()
        }
    }

    data class Gloves(
        override val id: ULID = ULID.nextULID(),
        override val enhancements: Enhancements = NONE,
        val protection: Int = 0,
    ) : Item(id = id, enhancements = enhancements) {
        companion object {
            val emptySlot = Gloves()
        }
    }

    data class Helmet(
        override val id: ULID = ULID.nextULID(),
        override val enhancements: Enhancements = NONE,
        val protection: Int = 0,
    ) : Item(id = id, enhancements = enhancements) {
        companion object {
            val emptySlot = Helmet()
        }
    }

    data class Mask(
        override val id: ULID = ULID.nextULID(),
        override val enhancements: Enhancements = NONE,
    ) : Item(id = id, enhancements = enhancements) {
        companion object {
            val emptySlot = Mask()
        }
    }

    data class Necklace(
        override val id: ULID = ULID.nextULID(),
        override val enhancements: Enhancements = NONE,
    ) : Item(id = id, enhancements = enhancements) {
        companion object {
            val emptySlot = Necklace()
        }
    }

    data class Ring(
        override val id: ULID = ULID.nextULID(),
        override val enhancements: Enhancements = NONE,
    ) : Item(id = id, enhancements = enhancements) {
        companion object {
            val emptySlot = Ring()
        }
    }

    data class Shield(
        override val id: ULID = ULID.nextULID(),
        override val enhancements: Enhancements = NONE,
        val protection: Int = 0,
    ) : Item(id = id, enhancements = enhancements) {
        companion object {
            val emptySlot = Shield()
        }
    }

    data class Weapon(
        override val id: ULID = ULID.nextULID(),
        override val enhancements: Enhancements = NONE,
        val type: WeaponType,
    ) : Item(id = id, enhancements = enhancements) {
        companion object {
            val emptySlot = Weapon(type = WeaponType.ONE_HANDED)
        }

        enum class WeaponType {
            ONE_HANDED,
            TWO_HANDED,
        }
    }
}
