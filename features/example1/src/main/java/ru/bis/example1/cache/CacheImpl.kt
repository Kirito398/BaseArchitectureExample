package ru.bis.example1.cache

import ru.bis.entities.Either
import ru.bis.entities.None
import ru.bis.example1.data.Cache

internal class CacheImpl(private val prefsManager: SharedPrefsManager) : Cache {
    override fun getData(): Either<None, String> = prefsManager.getData()
}