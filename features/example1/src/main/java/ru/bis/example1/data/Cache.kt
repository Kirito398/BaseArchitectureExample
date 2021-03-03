package ru.bis.example1.data

import ru.sir.core.Either
import ru.sir.core.None

interface Cache {
    fun getData(): Either<None, String>
}