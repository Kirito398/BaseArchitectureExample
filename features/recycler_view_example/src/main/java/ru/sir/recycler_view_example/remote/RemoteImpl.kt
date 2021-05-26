package ru.sir.recycler_view_example.remote

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.sir.recycler_view_example.data.Remote
import ru.sir.recycler_view_example_api.models.Item

class RemoteImpl : Remote {
    companion object {
        private const val RV_TITLE = 1
        private const val RV_ITEM = 2
    }

    override fun loadDataFromServer(): Flow<List<Item>> = flow {
        delay(1000)

        emit(mutableListOf(
            Item("Title 1", RV_TITLE),
            Item("Label 1", RV_ITEM),
            Item("Title 2", RV_TITLE),
            Item("Label 1", RV_ITEM),
            Item("Label 2", RV_ITEM),
            Item("Label 3", RV_ITEM),
            Item("Title 3", RV_TITLE),
            Item("Label 1", RV_ITEM),
            Item("Label 2", RV_ITEM),
            Item("Label 3", RV_ITEM),
            Item("Label 4", RV_ITEM)
        ))
    }
}