package com.example.radiobutton.customDialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.text.SimpleDateFormat
import java.util.*

class TimePickerFragment (val callback:(String)->Unit): DialogFragment(), TimePickerDialog.OnTimeSetListener{

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c=Calendar.getInstance()
        val hour=c.get(Calendar.HOUR_OF_DAY)
        val minute=c.get(Calendar.MINUTE)

        return TimePickerDialog(requireActivity(),this,hour,minute,DateFormat.is24HourFormat(requireActivity()))
    }
    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {

        val c =Calendar.getInstance()
        c.set(0,0,0,p1,p2)
        val selectTime= SimpleDateFormat("HH:mm")
            .format(Date(c.timeInMillis))

        callback(selectTime)
    }
}