package ru.bis.example1_api.interactor

import ru.bis.example1_api.interfaces.Repository
import ru.sir.core.Either
import ru.sir.core.None
import ru.sir.core.UseCase

class GetDataFromCache(private val repository: Repository) : UseCase<String, None, None>() {
    override fun run(params: None): Either<None, String> = repository.getDataFromCache()
}