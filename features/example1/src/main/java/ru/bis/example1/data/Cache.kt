package ru.bis.example1.data

import ru.bis.entities.Either
import ru.bis.entities.None

interface Cache {
    fun getData(): Either<None, String>
}