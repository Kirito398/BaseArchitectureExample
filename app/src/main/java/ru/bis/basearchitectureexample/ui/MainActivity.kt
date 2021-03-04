package ru.bis.basearchitectureexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.bis.basearchitectureexample.R
import ru.bis.example2.ui.fragments.Example2
import ru.bis.example1.ui.fragments.Example1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openDefaultFragments()
    }

    private fun openDefaultFragments() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.example1Layout, Example1())
            .replace(R.id.example2Layout, Example2())
            .commit()
    }
}