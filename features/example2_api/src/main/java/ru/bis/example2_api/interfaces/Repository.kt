package ru.bis.example2_api.interfaces

import ru.bis.entities.Either
import ru.bis.example2_api.type.Failure

interface Repository {
    fun getDataFromServer(name: String, secondName: String): Either<Failure, String>
}