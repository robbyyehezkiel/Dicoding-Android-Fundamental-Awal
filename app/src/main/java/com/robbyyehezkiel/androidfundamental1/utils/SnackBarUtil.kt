package com.robbyyehezkiel.androidfundamental1.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

object SnackBarUtil {

    fun showSnackBar(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }
}
