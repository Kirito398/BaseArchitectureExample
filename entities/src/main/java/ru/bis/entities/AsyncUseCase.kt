package ru.bis.entities

import kotlinx.coroutines.*

abstract class AsyncUseCase<out Type, in Params, out Failure> {
    private val ioContext = Dispatchers.IO
    private val mainContext = Dispatchers.Main

    private var parentJob: Job = Job()

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        unsubscribe()
        parentJob = Job()

        CoroutineScope(mainContext + parentJob).launch {
            val result = withContext(ioContext) {
                run(params)
            }

            onResult(result)
        }
    }

    fun unsubscribe() {
        parentJob.apply {
            cancelChildren()
            cancel()
        }
    }
}