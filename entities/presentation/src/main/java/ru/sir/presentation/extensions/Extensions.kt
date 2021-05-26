package ru.sir.presentation.extensions

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun String.easyLog(clazz: Any) {
    Log.d(clazz::class.java.simpleName, this)
}

fun String.showToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}

fun String.showSnackbar(activity: Activity) {
    val parent: View = activity.findViewById(android.R.id.content)
    Snackbar.make(parent, this, Snackbar.LENGTH_LONG).show()
}