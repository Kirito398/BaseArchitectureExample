package ru.bis.example2.di.components

import dagger.Subcomponent
import ru.bis.example2.di.modules.DataModule
import ru.bis.example2.di.modules.DomainModule
import ru.bis.example2.di.modules.PresentationModule
import ru.bis.example2.di.modules.RemoteModule
import ru.bis.example2.presentation.interfaces.Example2ViewContract
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [PresentationModule::class, DomainModule::class, DataModule::class, RemoteModule::class])
interface Example2Component {

    @Subcomponent.Factory
    interface Factory {
        fun create(): Example2Component
    }

    fun getExample2Presenter(): Example2ViewContract.Presenter
}