package ru.sir.recycler_view_example_api.interfaces

import ru.sir.core.Either
import ru.sir.core.None
import ru.sir.recycler_view_example_api.models.Item

interface Repository {
    fun loadData(): Either<None, List<Item>>
}