package ru.sir.presentation.extensions

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

fun <T> Flow<T>.launchWhenStarted(lifecycleCoroutineScope: LifecycleCoroutineScope, function: (T) -> Unit) {
    lifecycleCoroutineScope.launchWhenStarted {
        this@launchWhenStarted.collect() {
            function(it)
        }
    }
}

fun <T> Flow<T>.launchOn(scope: CoroutineScope, function: (T) -> Unit) {
    scope.launch {
        this@launchOn.collect {
            function(it)
        }
    }
}