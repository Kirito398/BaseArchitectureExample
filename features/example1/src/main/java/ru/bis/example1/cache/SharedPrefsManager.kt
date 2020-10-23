package ru.bis.example1.cache

import android.content.SharedPreferences
import ru.bis.entities.Either
import ru.bis.entities.None
import javax.inject.Inject

class SharedPrefsManager @Inject constructor(private val prefs: SharedPreferences) {
    companion object {
        const val DATA = "data"
        const val DEFAULT_DATA = "Hello world from cache!"
    }

    fun getData(): Either<None, String> {
        return Either.Right(prefs.getString(DATA, DEFAULT_DATA) ?: DEFAULT_DATA)
    }
}