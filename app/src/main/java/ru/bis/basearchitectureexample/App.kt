package ru.bis.basearchitectureexample

import android.content.Context
import ru.bis.basearchitectureexample.di.components.AppComponent
import ru.bis.basearchitectureexample.di.components.DaggerAppComponent
import ru.bis.example1.di.components.Example1Component
import ru.bis.example1.di.modules.ViewModelModule
import ru.bis.example1.di.modules.CacheModule as Example1CacheModule
import ru.bis.example2.di.components.Example2Component
import ru.bis.example2.di.provides.Example2ComponentProvider
import ru.sir.presentation.base.BaseApplication
import ru.sir.presentation.base.BaseDaggerComponent
import java.lang.IllegalArgumentException

class App : BaseApplication(), Example2ComponentProvider {
    companion object {
        lateinit var appComponent: AppComponent
        lateinit var appContext: Context
        private var example2Component: Example2Component? = null
    }

    override fun onCreate() {
        super.onCreate()

        appContext = applicationContext
        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.create()
    }

    override fun provideComponent(type: Class<out BaseDaggerComponent>): BaseDaggerComponent {
        return when(type) {
            Example1Component::class.java -> appComponent.createExample1Component().create(Example1CacheModule(this))
            //Example2Component::class.java -> appComponent.createExample2Component().create()
            else -> throw IllegalArgumentException("Dagger component not provided: $type")
        }
    }

    override fun provideExample2Component(): Example2Component {
        if (example2Component == null)
            example2Component = appComponent.createExample2Component().create()
        return example2Component!!
    }
}