package ru.sir.presentation.extensions

import android.content.Context
import android.util.Log
import android.widget.Toast

fun String.easyLog(clazz: Any) {
    Log.d(clazz::class.java.simpleName, this)
}

fun String.showToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}