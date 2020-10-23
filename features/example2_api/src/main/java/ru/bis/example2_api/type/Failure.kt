package ru.bis.example2_api.type

sealed class Failure {
    object NetworkConnectionError : Failure()
    object ServerError : Failure()
    object ServerNotFoundError : Failure()
    object AuthorizationError : Failure()
    object AccountNotFoundError : Failure()
    object UnknownError : Failure()
}