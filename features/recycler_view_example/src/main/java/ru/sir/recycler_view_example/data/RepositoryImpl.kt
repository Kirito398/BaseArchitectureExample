package ru.sir.recycler_view_example.data

import kotlinx.coroutines.flow.Flow
import ru.sir.recycler_view_example_api.interfaces.Repository
import ru.sir.recycler_view_example_api.models.Item

class RepositoryImpl(private val remote: Remote) : Repository {
    override fun loadData(): Flow<List<Item>> = remote.loadDataFromServer()
}