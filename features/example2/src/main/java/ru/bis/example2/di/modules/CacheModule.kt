package ru.bis.example2.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ru.sir.presentation.base.BaseApplication

@Module
class CacheModule(private val context: Context) {
    @Provides
    fun provideAppContext(): Context = context

    @Provides
    fun provideApplication(): Application = context as BaseApplication
}