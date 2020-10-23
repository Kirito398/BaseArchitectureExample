package ru.bis.example1.di.components

import dagger.Subcomponent
import ru.bis.example1.di.modules.CacheModule
import ru.bis.example1.di.modules.DataModule
import ru.bis.example1.di.modules.DomainModule
import ru.bis.example1.di.modules.PresentationModule
import ru.bis.example1.presentation.interfaces.Example1ViewContract
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [PresentationModule::class, DomainModule::class, DataModule::class, CacheModule::class])
interface Example1Component {

    @Subcomponent.Factory
    interface Factory {
        fun create(cacheModule: CacheModule): Example1Component
    }

    fun getExample1Presenter(): Example1ViewContract.Presenter
}