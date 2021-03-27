package ru.sir.recycler_view_example.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.sir.presentation.annotations.ViewModelKey
import ru.sir.presentation.factories.ViewModelFactory
import ru.sir.recycler_view_example.view_models.RecyclerViewExampleViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RecyclerViewExampleViewModel::class)
    abstract fun bindRecyclerViewExampleViewModel(recyclerViewExampleViewModel: RecyclerViewExampleViewModel): ViewModel
}