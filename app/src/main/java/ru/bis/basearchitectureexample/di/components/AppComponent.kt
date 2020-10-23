package ru.bis.basearchitectureexample.di.components

import dagger.Component
import ru.bis.example1.di.components.Example1Component
import ru.bis.example2.di.components.Example2Component

@Component
interface AppComponent {
    fun createExample1Component(): Example1Component.Factory
    fun createExample2Component(): Example2Component.Factory
}