package ru.sir.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<out Type, in Params, out Failure> {
    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params) = flow {
        val result = run(params)
        emit(result)
    }.flowOn(Dispatchers.IO)
}