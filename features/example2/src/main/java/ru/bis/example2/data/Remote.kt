package ru.bis.example2.data

import ru.bis.entities.Either
import ru.bis.example2_api.type.Failure

interface Remote {
    fun getData(name: String, secondName: String): Either<Failure, String>
}