package ru.bis.example2_api.interactor

import ru.bis.example2_api.interfaces.Repository
import ru.bis.example2_api.type.Failure
import ru.sir.core.AsyncUseCase
import ru.sir.core.Either

class GetDataFromServer(private val repository: Repository) : AsyncUseCase<String, GetDataFromServer.Params, Failure>() {

    data class Params (
        val name: String,
        val secondName: String
    )

    override suspend fun run(params: Params): Either<Failure, String> = repository.getDataFromServer(params.name, params.secondName)
}