package ru.bis.example1_api.interfaces

import ru.bis.entities.Either
import ru.bis.entities.None

interface Repository {
    fun getDataFromCache(): Either<None, String>
}