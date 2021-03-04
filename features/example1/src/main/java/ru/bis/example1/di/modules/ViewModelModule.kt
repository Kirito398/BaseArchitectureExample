package ru.bis.example1.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.sir.presentation.annotations.ViewModelKey
import ru.bis.example1.view_models.Example1ViewModel
import ru.sir.presentation.factories.ViewModelFactory

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(Example1ViewModel::class)
    abstract fun bindExample1ViewModel(example1ViewModel: Example1ViewModel): ViewModel
}