package ru.sir.recycler_view_example_api.interactor

import kotlinx.coroutines.flow.Flow
import ru.sir.core.FlowUseCase
import ru.sir.core.None
import ru.sir.recycler_view_example_api.interfaces.Repository
import ru.sir.recycler_view_example_api.models.Item

class LoadData(private val repository: Repository) : FlowUseCase<List<Item>, None>() {
    override fun run(params: None): Flow<List<Item>> = repository.loadData()
}