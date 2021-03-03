package ru.bis.data.remote

import retrofit2.Call
import retrofit2.Response
import ru.sir.core.Either

abstract class BaseRequest<Failure> (private val networkHandler: NetworkHandler) {
    fun <Response, Type> make(call: Call<Type>, transform: (Type) -> Response): Either<Failure, Response> {
        return when (networkHandler.isNetworkConnected()) {
            true -> execute(call, transform)
            false -> Either.Left(getNetworkFailure())
        }
    }

    private fun <Response, Type> execute(call: Call<Type>, transform: (Type) -> Response): Either<Failure, Response> {
        return try {
            val response = call.execute()
            when (response.isSucceed()) {
                true -> Either.Right(transform(response.body()!!))
                false -> Either.Left(response.parseError())
            }
        } catch (e: Throwable) {
            Either.Left(getServerError())
        }
    }

    abstract fun <Type> Response<Type>.parseError(): Failure
    abstract fun getNetworkFailure(): Failure
    abstract fun getServerError(): Failure
}

private fun <Type> Response<Type>.isSucceed(): Boolean = isSuccessful && body() != null