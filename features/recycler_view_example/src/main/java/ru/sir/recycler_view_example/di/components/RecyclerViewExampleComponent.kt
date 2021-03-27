package ru.sir.recycler_view_example.di.components

import dagger.Subcomponent
import ru.sir.presentation.base.BaseDaggerComponent
import ru.sir.recycler_view_example.di.modules.*
import ru.sir.recycler_view_example.ui.RecyclerViewExample
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [ViewModelModule::class, DomainModule::class, DataModule::class, RemoteModule::class, CacheModule::class])
interface RecyclerViewExampleComponent : BaseDaggerComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(cacheModule: CacheModule): RecyclerViewExampleComponent
    }

    fun inject(recyclerViewExample: RecyclerViewExample)
}