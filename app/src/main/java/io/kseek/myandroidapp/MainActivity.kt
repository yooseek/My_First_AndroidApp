package io.kseek.myandroidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNextPage = findViewById<Button>(R.id.customNextBtn)
        btnNextPage.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
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