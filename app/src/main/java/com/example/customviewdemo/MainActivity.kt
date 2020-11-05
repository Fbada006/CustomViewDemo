package com.example.customviewdemo

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myView = findViewById<MyCustomView>(R.id.custom_view)
        myView.setCircleColor(Color.GREEN);
        myView.setLabelColor(Color.MAGENTA);
        myView.setLabelText("Help");
    }
}