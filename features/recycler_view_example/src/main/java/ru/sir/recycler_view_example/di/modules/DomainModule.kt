package ru.sir.recycler_view_example.di.modules

import dagger.Module
import dagger.Provides
import ru.sir.recycler_view_example_api.interactor.LoadData
import ru.sir.recycler_view_example_api.interfaces.Repository

@Module
class DomainModule {

    @Provides
    fun provideLoadData(repository: Repository): LoadData = LoadData(repository)
}