package ru.sir.recycler_view_example.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class CacheModule(private val context: Context) {

    @Provides
    fun provideContext(): Context = context

    @Provides
    fun provideApplication(): Application = context as Application
}