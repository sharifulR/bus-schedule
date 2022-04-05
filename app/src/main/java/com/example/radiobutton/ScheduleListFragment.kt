package com.example.radiobutton

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.radiobutton.databinding.FragmentScheduleListBinding

class ScheduleListFragment : Fragment() {
    private lateinit var binding:FragmentScheduleListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentScheduleListBinding.inflate(inflater,container,false)
        val scheduleAdapter=ScheduleAdapter()
        binding.scheduleRV.layoutManager=LinearLayoutManager(requireActivity())
        binding.scheduleRV.adapter=scheduleAdapter
        scheduleAdapter.submitList(scheduleList)
        //scroll visible
        binding.scheduleRV.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy>0){
                    binding.fab.hide()
                }else{
                    binding.fab.show()
                }
            }
        })
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_scheduleListFragment_to_homeFragment)
        }
        return binding.root
    }

}