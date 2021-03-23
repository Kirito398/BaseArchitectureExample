package ru.sir.recycler_view_example.data

import ru.sir.core.Either
import ru.sir.core.None
import ru.sir.recycler_view_example_api.models.Item

interface Remote {
    fun loadDataFromServer(): Either<None, List<Item>>
}