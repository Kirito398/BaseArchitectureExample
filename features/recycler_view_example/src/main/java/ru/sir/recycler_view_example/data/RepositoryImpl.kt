package ru.sir.recycler_view_example.data

import ru.sir.core.Either
import ru.sir.core.None
import ru.sir.recycler_view_example_api.interfaces.Repository
import ru.sir.recycler_view_example_api.models.Item

class RepositoryImpl(private val remote: Remote) : Repository {
    override fun loadData(): Either<None, List<Item>> = remote.loadDataFromServer()
}