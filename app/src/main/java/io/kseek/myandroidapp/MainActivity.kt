package io.kseek.myandroidapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNextPage = findViewById<Button>(R.id.customNextBtn)
        btnNextPage.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
//            finish()
        }

    }
}