package ru.bis.example1.cache

import ru.bis.example1.data.Cache
import ru.sir.core.Either
import ru.sir.core.None

internal class CacheImpl(private val prefsManager: SharedPrefsManager) : Cache {
    override fun getData(): Either<None, String> = prefsManager.getData()
}