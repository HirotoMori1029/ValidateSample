package com.hirogram.validatesample

import android.os.Handler
import android.os.Looper
import androidx.databinding.BaseObservable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData

class MainForm : BaseObservable() {
    val to = ObservableField("")
    val subject = ObservableField("")
    val message = ObservableField("")
    val valid = ObservableBoolean(true)
    val requesting = ObservableBoolean()

    val onComplete = MutableLiveData<Boolean>()

    fun validate() {
        val result = !to.get().isNullOrBlank()
        valid.set(result)
        if (result) {
            requesting.set(true)
            send()
        }
    }

    private fun send() {
        Handler(Looper.getMainLooper()).postDelayed({
            onComplete.postValue(true)
        }, 3000)
    }

}