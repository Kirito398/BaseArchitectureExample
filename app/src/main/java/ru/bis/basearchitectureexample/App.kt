package ru.bis.basearchitectureexample

import android.app.Application
import android.content.Context
import ru.bis.basearchitectureexample.di.components.AppComponent
import ru.bis.basearchitectureexample.di.components.DaggerAppComponent
import ru.bis.example1.di.components.Example1Component
import ru.bis.example1.di.modules.CacheModule as Example1CacheModule
import ru.bis.example1.di.provides.Example1ComponentProvider
import ru.bis.example2.di.components.Example2Component
import ru.bis.example2.di.provides.Example2ComponentProvider

class App : Application(), Example1ComponentProvider, Example2ComponentProvider {
    companion object {
        lateinit var appComponent: AppComponent
        lateinit var appContext: Context
        private var example1Component: Example1Component? = null
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

    override fun provideExample1Component(): Example1Component {
        if (example1Component == null)
            example1Component = appComponent.createExample1Component().create(Example1CacheModule(this))
        return example1Component!!
    }

    override fun provideExample2Component(): Example2Component {
        if (example2Component == null)
            example2Component = appComponent.createExample2Component().create()
        return example2Component!!
    }
}