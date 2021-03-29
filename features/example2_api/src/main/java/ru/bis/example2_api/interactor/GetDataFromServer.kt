package ru.bis.example2_api.interactor

import ru.bis.example2_api.interfaces.Repository
import ru.bis.example2_api.type.Failure
import ru.sir.core.Either
import ru.sir.core.FlowUseCase

class GetDataFromServer(private val repository: Repository) : FlowUseCase<String, GetDataFromServer.Params, Failure>() {

    data class Params (
        val name: String,
        val secondName: String
    )

    override suspend fun run(params: Params): Either<Failure, String> = repository.getDataFromServer(params.name, params.secondName)
}