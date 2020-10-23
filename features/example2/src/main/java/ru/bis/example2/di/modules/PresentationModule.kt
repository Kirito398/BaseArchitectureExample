package ru.bis.example2.di.modules

import dagger.Module
import dagger.Provides
import ru.bis.example2.presentation.interfaces.Example2ViewContract
import ru.bis.example2.presentation.presenters.Example2Presenter
import ru.bis.example2_api.interactor.GetDataFromServer

@Module
class PresentationModule {

    @Provides
    fun provideExample2Presenter(getDataFromServer: GetDataFromServer): Example2ViewContract.Presenter {
        return Example2Presenter(getDataFromServer)
    }
}