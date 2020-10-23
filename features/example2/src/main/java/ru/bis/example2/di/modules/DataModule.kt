package ru.bis.example2.di.modules

import dagger.Module
import dagger.Provides
import ru.bis.example2.data.Remote
import ru.bis.example2.data.RepositoryImpl
import ru.bis.example2_api.interfaces.Repository
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideRepository(remote: Remote): Repository {
        return RepositoryImpl(remote)
    }
}