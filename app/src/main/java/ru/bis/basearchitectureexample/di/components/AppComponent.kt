package ru.bis.basearchitectureexample.di.components

import dagger.Component
import ru.bis.example1.di.components.Example1Component
import ru.bis.example2.di.components.Example2Component
import ru.sir.recycler_view_example.di.components.RecyclerViewExampleComponent

@Component
interface AppComponent {
    fun createExample1Component(): Example1Component.Factory
    fun createExample2Component(): Example2Component.Factory
    fun createRecyclerViewExampleComponent(): RecyclerViewExampleComponent.Factory
}