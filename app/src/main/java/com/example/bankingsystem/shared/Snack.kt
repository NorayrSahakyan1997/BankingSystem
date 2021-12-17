package com.example.bankingsystem.shared
import android.view.View
import com.google.android.material.snackbar.Snackbar


object Snack {
    fun createSnack(parentLayout: View, message: String) {
        val snack = Snackbar
            .make(parentLayout, message, Snackbar.LENGTH_LONG)
        snack.show()
    }
}