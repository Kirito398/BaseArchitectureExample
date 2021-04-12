package ru.sir.recycler_view_example_api.interfaces

import kotlinx.coroutines.flow.Flow
import ru.sir.recycler_view_example_api.models.Item

interface Repository {
    fun loadData(): Flow<List<Item>>
}