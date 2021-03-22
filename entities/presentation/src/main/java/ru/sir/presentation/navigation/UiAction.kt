package ru.sir.presentation.navigation

import android.os.Bundle

data class UiAction(
    val action: String,
    val data: Bundle? = null
)