package randomize

data class Ability(val name: AbilityName, val value: Int)

sealed interface AbilityName {
    data object Strength : AbilityName
    data object Agility : AbilityName
    data object Perception : AbilityName
}