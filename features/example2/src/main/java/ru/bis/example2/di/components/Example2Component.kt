package ru.bis.example2.di.components

import dagger.Subcomponent
import ru.bis.example2.di.modules.*
import ru.bis.example2.ui.fragments.Example2
import ru.sir.presentation.base.BaseDaggerComponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [ViewModelModule::class, DomainModule::class, DataModule::class, RemoteModule::class, CacheModule::class])
interface Example2Component : BaseDaggerComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(cacheModule: CacheModule): Example2Component
    }

    fun inject(fragment: Example2)
}