package ru.bis.example2.data

import ru.bis.example2_api.interfaces.Repository
import ru.bis.example2_api.type.Failure
import ru.sir.core.Either

internal class RepositoryImpl(private val remote: Remote) : Repository {
    override fun getDataFromServer(name: String, secondName: String): Either<Failure, String>
            = remote.getData(name, secondName)
}