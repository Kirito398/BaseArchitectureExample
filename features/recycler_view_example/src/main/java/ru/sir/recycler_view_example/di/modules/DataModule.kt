package ru.sir.recycler_view_example.di.modules

import dagger.Module
import dagger.Provides
import ru.sir.recycler_view_example.data.Remote
import ru.sir.recycler_view_example.data.RepositoryImpl
import ru.sir.recycler_view_example_api.interfaces.Repository
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideRepository(remote: Remote): Repository = RepositoryImpl(remote)
}