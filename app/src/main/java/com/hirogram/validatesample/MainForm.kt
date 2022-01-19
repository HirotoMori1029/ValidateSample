package com.hirogram.validatesample

import android.content.Context
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField

class MainForm : BaseObservable() {
    val to = ObservableField("")
    val subject = ObservableField("")
    val message = ObservableField("")
    val valid = ObservableBoolean(true)

    fun validate(context: Context) {
        val result = !to.get().isNullOrBlank()
        valid.set(result)
        if (result) {
            send(context)
        }
    }

    private fun send(context: Context) {
        Toast.makeText(context, message.get(), Toast.LENGTH_SHORT).show()
    }

}