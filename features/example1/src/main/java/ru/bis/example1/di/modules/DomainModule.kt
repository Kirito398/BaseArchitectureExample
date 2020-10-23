package ru.bis.example1.di.modules

import dagger.Module
import dagger.Provides
import ru.bis.example1_api.interactor.GetDataFromCache
import ru.bis.example1_api.interfaces.Repository

@Module
class DomainModule {

    @Provides
    fun provideGetDataFromCache(repository: Repository): GetDataFromCache {
        return GetDataFromCache(repository)
    }
}