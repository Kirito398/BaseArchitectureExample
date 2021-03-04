package ru.bis.example1.di.components

import dagger.Subcomponent
import ru.bis.example1.di.modules.CacheModule
import ru.bis.example1.di.modules.DataModule
import ru.bis.example1.di.modules.DomainModule
import ru.bis.example1.di.modules.ViewModelModule
import ru.bis.example1.ui.fragments.Example1
import ru.sir.presentation.base.BaseDaggerComponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [ViewModelModule::class, DomainModule::class, DataModule::class, CacheModule::class])
interface Example1Component : BaseDaggerComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(cacheModule: CacheModule): Example1Component
    }

    fun inject(fragment: Example1)
}