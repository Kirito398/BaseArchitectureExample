package ru.bis.example1.di.modules

import dagger.Module
import dagger.Provides
import ru.bis.example1.data.Cache
import ru.bis.example1.data.RepositoryImpl
import ru.bis.example1_api.interfaces.Repository
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideRepository(cache: Cache): Repository {
        return RepositoryImpl(cache)
    }
}