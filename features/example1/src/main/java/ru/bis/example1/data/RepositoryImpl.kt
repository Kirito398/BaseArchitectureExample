package ru.bis.example1.data

import ru.bis.example1_api.interfaces.Repository
import ru.sir.core.Either
import ru.sir.core.None

internal class RepositoryImpl(private val cache: Cache) : Repository {
    override fun getDataFromCache(): Either<None, String> = cache.getData()
}