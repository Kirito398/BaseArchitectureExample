package ru.sir.recycler_view_example.data

import kotlinx.coroutines.flow.Flow
import ru.sir.recycler_view_example_api.models.Item

interface Remote {
    fun loadDataFromServer(): Flow<List<Item>>
}