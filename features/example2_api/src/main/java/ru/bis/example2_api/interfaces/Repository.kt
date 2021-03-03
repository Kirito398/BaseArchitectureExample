package ru.bis.example2_api.interfaces

import ru.bis.example2_api.type.Failure
import ru.sir.core.Either

interface Repository {
    fun getDataFromServer(name: String, secondName: String): Either<Failure, String>
}