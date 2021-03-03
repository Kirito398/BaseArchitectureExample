package ru.bis.example2.data

import ru.bis.example2_api.type.Failure
import ru.sir.core.Either

interface Remote {
    fun getData(name: String, secondName: String): Either<Failure, String>
}