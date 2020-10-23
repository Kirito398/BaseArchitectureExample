package ru.bis.example2.di.modules

import dagger.Module
import dagger.Provides
import ru.bis.example2.data.Remote
import ru.bis.example2.remote.RemoteImpl

@Module
class RemoteModule {
    @Provides
    fun provideRemote(): Remote {
        return RemoteImpl()
    }
}