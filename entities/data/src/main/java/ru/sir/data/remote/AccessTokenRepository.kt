package ru.sir.data.remote

interface AccessTokenRepository {
    fun refreshAccessToken(): String
    fun getAccessToken(): String
}