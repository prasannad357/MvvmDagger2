package com.practice.mvvmdagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.practice.mvvmdagger2.viewmodel.MainViewModel
import com.practice.mvvmdagger2.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModeFactory:ViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = (application as MainApplication).mainComponent
        component.inject(this)
        val viewModel = ViewModelProvider(this, viewModeFactory)[MainViewModel::class.java]
        val tv = findViewById<TextView>(R.id.tvTextView)
        viewModel.quoteList.observe(this){
            tv.text = it.toString()
        }

    }
}