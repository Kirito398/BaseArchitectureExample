package ru.bis.example1_api.interactor

import ru.bis.entities.Either
import ru.bis.entities.None
import ru.bis.entities.UseCase
import ru.bis.example1_api.interfaces.Repository

class GetDataFromCache(private val repository: Repository) : UseCase<String, None, None>() {
    override fun run(params: None): Either<None, String> = repository.getDataFromCache()
}