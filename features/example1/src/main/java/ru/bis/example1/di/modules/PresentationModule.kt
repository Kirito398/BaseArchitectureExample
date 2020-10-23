package ru.bis.example1.di.modules

import dagger.Module
import dagger.Provides
import ru.bis.example1.presentation.interfaces.Example1ViewContract
import ru.bis.example1.presentation.presenters.Example1Presenter
import ru.bis.example1_api.interactor.GetDataFromCache

@Module
class PresentationModule {

    @Provides
    fun provideExample1Presenter(getDataFromCache: GetDataFromCache): Example1ViewContract.Presenter {
        return Example1Presenter(getDataFromCache)
    }
}