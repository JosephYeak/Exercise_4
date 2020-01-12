package com.example.exercise_4

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var getDate = Calendar.getInstance()
        val todayDate = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, day ->
            getDate.set(year, month, day)

            var getAge =  todayDate.get(Calendar.YEAR) - getDate.get(Calendar.YEAR)
            if(todayDate.get(Calendar.MONTH) < getDate.get(Calendar.MONTH)){
                if(todayDate.get(Calendar.DAY_OF_MONTH) < getDate.get(Calendar.DAY_OF_MONTH)) {
                    getAge--
                }
            }
            age.text = "Age: $getAge"

            var savings : Int
            savings = when (getAge) {
                in 16..20 -> 5000
                in 21..25 -> 14000
                in 26..30 -> 29000
                in 31..35 -> 50000
                in 36..40 -> 78000
                in 41..45 -> 116000
                in 46..50 -> 165000
                in 51..55 -> 228000
                else -> 0
            }
            saving.text = "Minimum Basic Saving: RM " + savings.toString()
        }

         button.setOnClickListener{
            DatePickerDialog(this, datePicker, getDate.get(Calendar.YEAR), getDate.get(
                Calendar.MONTH), getDate.get(Calendar.DAY_OF_MONTH)).show().toString()
        }
    }
}
