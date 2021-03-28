package ru.sir.presentation.extensions

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

fun String.easyLog(clazz: Any) {
    Log.d(clazz::class.java.simpleName, this)
}

fun String.showToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}

fun <T> Flow<T>.launchWhenStarted(lifecycleCoroutineScope: LifecycleCoroutineScope, function: (T) -> Unit) {
    lifecycleCoroutineScope.launchWhenStarted {
        this@launchWhenStarted.collect() {
            function(it)
        }
    }
}