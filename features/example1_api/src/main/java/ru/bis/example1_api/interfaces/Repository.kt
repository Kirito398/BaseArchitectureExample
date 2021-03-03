package ru.bis.example1_api.interfaces

import ru.sir.core.Either
import ru.sir.core.None

interface Repository {
    fun getDataFromCache(): Either<None, String>
}