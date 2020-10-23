package ru.bis.example1.di.provides

import ru.bis.example1.di.components.Example1Component

interface Example1ComponentProvider {
    fun provideExample1Component(): Example1Component
}