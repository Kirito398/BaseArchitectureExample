package ru.sir.recycler_view_example_api.interactor

import ru.sir.core.Either
import ru.sir.core.FlowUseCase
import ru.sir.core.None
import ru.sir.recycler_view_example_api.interfaces.Repository
import ru.sir.recycler_view_example_api.models.Item

class LoadData(private val repository: Repository) : FlowUseCase<List<Item>, None, None>() {
    override suspend fun run(params: None): Either<None, List<Item>> = repository.loadData()
}