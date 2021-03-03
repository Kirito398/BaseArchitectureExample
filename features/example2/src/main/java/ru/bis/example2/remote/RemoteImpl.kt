package ru.bis.example2.remote

import ru.bis.example2.data.Remote
import ru.bis.example2_api.type.Failure
import ru.sir.core.Either

internal class RemoteImpl : Remote {
    override fun getData(name: String, secondName: String): Either<Failure, String> {
        val data = "Hello world from server, $name $secondName!"

        for (i in 0 .. Int.MAX_VALUE) {
            //Имитация работы сервера
        }

        return Either.Right(data)
    }
}