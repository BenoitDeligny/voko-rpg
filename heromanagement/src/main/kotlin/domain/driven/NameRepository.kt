package domain.driven

import domain.model.Name.FirstName
import domain.model.Name.LastName

interface NameRepository {
    fun firstNames(): List<FirstName>
    fun lastNames(): List<LastName>
}
