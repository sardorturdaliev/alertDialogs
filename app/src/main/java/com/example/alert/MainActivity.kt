package com.example.alert

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.example.alert.databinding.ActivityMainBinding
import com.example.alert.databinding.CustomDialogBinding
import com.example.alert.databinding.FragmentMyDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAlert.setOnClickListener {
            alertDialog()
        }
        binding.btnCustomdialog.setOnClickListener {
            customDialog()
        }
        binding.btnFragmentDialog.setOnClickListener {
            fragmetdialog()
        }
        binding.btnDataPicker.setOnClickListener {
            datePicker()
        }
        binding.btnTimerPicker.setOnClickListener {
            timerPicker()
        }
        binding.btnBottomSheet.setOnClickListener {
            bottomSheetDialog()
        }
        binding.btnSnackBar.setOnClickListener {
            snackbar()
        }

    }

    private fun snackbar() {
        val snack = Snackbar.make(binding.root, "Snack Bar", Snackbar.LENGTH_SHORT)
        snack.setAction("Ok", View.OnClickListener {
            Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
        })
        snack.show()
    }
    private fun alertDialog() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Alert")
        dialog.setMessage("WELCOME TO ALERT")
        dialog.setPositiveButton("Yes") { _, _ ->
            Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show()
        }

        dialog.show()
    }
    private fun customDialog() {
        val dialog = AlertDialog.Builder(this).create()
        val customdialog = CustomDialogBinding.inflate(layoutInflater)
        dialog.setView(customdialog.root)

        customdialog.btnclick.setOnClickListener {
            dialog.cancel()
        }
        dialog.show()
    }
    private fun fragmetdialog() {
        val myfr = MyFragment_Dialog()
        myfr.show(supportFragmentManager, MyFragment_Dialog().toString())
        myfr.setOnClickButton {
            myfr.dismiss()
        }
    }
    private fun timerPicker() {

        val date = Date()
        val dialog = TimePickerDialog(
            this, object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                    Toast.makeText(this@MainActivity, "$p1/$p2", Toast.LENGTH_SHORT).show()
                }

            }, date.hours, date.minutes, true
        )
        dialog.show()

    }
    private fun datePicker() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val moth = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val date = Date()
        val dateDialog = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                Toast.makeText(this@MainActivity, "$p1/$p2/$p3", Toast.LENGTH_SHORT).show()
            }
        }, year, moth, day).show()
    }
    private fun bottomSheetDialog() {
        val fr = MyFragment_Dialog()
        val dialog = BottomSheetDialog(this)
        val item = FragmentMyDialogBinding.inflate(layoutInflater)
        dialog.setContentView(item.root)
        item.btnclick.setOnClickListener {
            dialog.cancel()
        }
        dialog.show()

    }


}