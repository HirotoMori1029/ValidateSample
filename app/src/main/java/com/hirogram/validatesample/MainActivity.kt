package com.hirogram.validatesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.hirogram.validatesample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding :ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val form = MainForm()
        form.onComplete.observe(this, Observer {
            Toast.makeText(this, "送信しました", Toast.LENGTH_SHORT).show()
            finish()
        })
        binding.form = form
    }
}