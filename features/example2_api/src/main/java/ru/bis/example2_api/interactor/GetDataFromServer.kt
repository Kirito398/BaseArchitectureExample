package ru.bis.example2_api.interactor

import ru.bis.entities.AsyncUseCase
import ru.bis.entities.Either
import ru.bis.example2_api.interfaces.Repository
import ru.bis.example2_api.type.Failure

class GetDataFromServer(private val repository: Repository) : AsyncUseCase<String, GetDataFromServer.Params, Failure>() {

    data class Params (
        val name: String,
        val secondName: String
    )

    override suspend fun run(params: Params): Either<Failure, String> = repository.getDataFromServer(params.name, params.secondName)
}