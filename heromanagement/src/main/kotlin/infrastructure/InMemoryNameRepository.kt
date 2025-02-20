package infrastructure

import domain.model.Name.FirstName
import domain.model.Name.LastName
import domain.driven.NameRepository
import name.NameDatabase

class InMemoryNameRepository : NameRepository {
    private val database = NameDatabase()

    override fun firstNames(): List<FirstName> = database
        .firstNames()
        .map { FirstName(it) }

    override fun lastNames(): List<LastName> = database
        .lastNames()
        .map { LastName(it) }
}
