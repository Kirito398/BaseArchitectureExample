package ru.sir.recycler_view_example.di.modules

import dagger.Module
import dagger.Provides
import ru.sir.recycler_view_example.data.Remote
import ru.sir.recycler_view_example.remote.RemoteImpl
import javax.inject.Singleton

@Module
class RemoteModule {

    @Provides
    @Singleton
    fun provideRemote(): Remote = RemoteImpl()
}