package ru.bis.entities

abstract class UseCase<out Type, in Params, out Failure> {
    abstract fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        onResult(run(params))
    }
}