package io.kseek.myandroidapp

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.button)

        btnDatePicker.setOnClickListener {
            clickDatePicker()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun clickDatePicker() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{ view, year, month, dayOfMonth ->
                Toast.makeText(this, "Year $year, month ${month +1}, day $dayOfMonth", Toast.LENGTH_LONG).show()

                val td = SimpleDateFormat("dd/MM/yyyy", Locale.KOREAN).parse("$dayOfMonth/${month+1}/$year")
                println(td)

            },
            year,
            month,
            day
        ).show()

        Toast.makeText(this, "btnDatePrick pressed", Toast.LENGTH_LONG).show()
    }

}