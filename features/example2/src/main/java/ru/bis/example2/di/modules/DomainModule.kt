package ru.bis.example2.di.modules

import dagger.Module
import dagger.Provides
import ru.bis.example2_api.interactor.GetDataFromServer
import ru.bis.example2_api.interfaces.Repository

@Module
class DomainModule {

    @Provides
    fun provideGetDataFromServer(repository: Repository): GetDataFromServer {
        return GetDataFromServer(repository)
    }
}