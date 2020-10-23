package ru.bis.example1.data

import ru.bis.entities.Either
import ru.bis.entities.None
import ru.bis.example1_api.interfaces.Repository

internal class RepositoryImpl(private val cache: Cache) : Repository {
    override fun getDataFromCache(): Either<None, String> = cache.getData()
}