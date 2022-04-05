package com.example.radiobutton

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.view.get
import androidx.navigation.fragment.findNavController
import com.example.radiobutton.customDialog.DatePickerFragment
import com.example.radiobutton.customDialog.TimePickerFragment
import com.example.radiobutton.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding
    private var from="Dhaka"
    private var to="Rajshahi"
    private var busType="economy"
    private var selectDate=""
    private var selectTime=""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(inflater,container,false)
        initCitySpinner()
        initBusTypeRadioGroup()
        binding.dateBtn.setOnClickListener {
            DatePickerFragment {
                selectDate=it
                binding.dateTV.text=it
            }.show(childFragmentManager,null)
        }
        binding.timeBtn.setOnClickListener {

            TimePickerFragment{
                selectTime=it
                binding.timeTV.text=it
            }.show(childFragmentManager,null)
        }
        binding.saveBtn.setOnClickListener {
            saveInfo()
        }
        return binding.root
    }

    private fun saveInfo() {

        val busName=binding.busNameET.text.toString()
        if (busName.isEmpty()){
            binding.busNameET.error=getString(R.string.bus_nam_chck)
            return
        }
        if (from==to){
            Toast.makeText(activity,
                "Origin and destination cannot be the same",
                Toast.LENGTH_LONG).show()
            return
        }
        val schedule=BusSchedule(
            id=System.currentTimeMillis(),
            name=busName,
            from=from,
            to=to,
            date = selectDate,
            time = selectTime,
            busType=busType
        )
        scheduleList.add(schedule)
        findNavController().navigate(R.id.action_homeFragment_to_scheduleListFragment)
        Toast.makeText(activity,
            "$schedule",
            Toast.LENGTH_LONG).show()
    }

    private fun initBusTypeRadioGroup() {
        binding.RBGroup.setOnCheckedChangeListener { radioGroup, i ->
            val rb:RadioButton=radioGroup.findViewById(i)
            busType=rb.text.toString()
        }
    }

    private fun initCitySpinner() {
        val cityAdapter=ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
            cityList
        )
        binding.fromSP.adapter=cityAdapter
        binding.toSP.adapter=cityAdapter

        binding.fromSP.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                from=p0?.getItemAtPosition(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
        binding.toSP.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                to=p0?.getItemAtPosition(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }
}
val cityList= listOf("Dhaka","Rajshahi","Khulna","Sylhet","Comilla")