package ru.bis.basearchitectureexample

import ru.bis.basearchitectureexample.di.components.AppComponent
import ru.bis.basearchitectureexample.di.components.DaggerAppComponent
import ru.bis.example1.di.components.Example1Component
import ru.bis.example2.di.components.Example2Component
import ru.bis.example2.di.modules.CacheModule as Example2CacheModule
import ru.bis.example1.di.modules.CacheModule as Example1CacheModule
import ru.sir.presentation.base.BaseApplication
import ru.sir.presentation.base.BaseDaggerComponent
import java.lang.IllegalArgumentException

class App : BaseApplication() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.create()
    }

    override fun provideComponent(type: Class<out BaseDaggerComponent>): BaseDaggerComponent {
        return when(type) {
            Example1Component::class.java -> appComponent.createExample1Component().create(Example1CacheModule(this))
            Example2Component::class.java -> appComponent.createExample2Component().create(Example2CacheModule(this))
            else -> throw IllegalArgumentException("Dagger component not provided: $type")
        }
    }
}