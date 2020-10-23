package ru.bis.example2.di.provides

import ru.bis.example2.di.components.Example2Component

interface Example2ComponentProvider {
    fun provideExample2Component(): Example2Component
}