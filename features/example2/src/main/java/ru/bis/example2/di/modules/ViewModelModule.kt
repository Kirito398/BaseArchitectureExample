package ru.bis.example2.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.bis.example2.view_models.Example2ViewModel
import ru.sir.presentation.annotations.ViewModelKey
import ru.sir.presentation.factories.ViewModelFactory

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModuleFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(Example2ViewModel::class)
    abstract fun bindExample2ViewModule(model: Example2ViewModel): ViewModel
}