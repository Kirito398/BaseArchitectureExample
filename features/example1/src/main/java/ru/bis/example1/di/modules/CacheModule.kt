package ru.bis.example1.di.modules

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

import ru.bis.example1.cache.CacheImpl
import ru.bis.example1.cache.SharedPrefsManager
import ru.bis.example1.data.Cache

@Module
class CacheModule(private val context: Context) {
    @Provides
    fun provideAppContext(): Context = context

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideCache(prefsManager: SharedPrefsManager): Cache {
        return CacheImpl(prefsManager)
    }
}