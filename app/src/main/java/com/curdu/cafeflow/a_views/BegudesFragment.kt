package com.curdu.cafeflow.a_views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.curdu.cafeflow.R
import com.curdu.cafeflow.b_viewmodels.BegudesVM
import com.curdu.cafeflow.b_viewmodels.SharedViewModel
import com.curdu.cafeflow.databinding.FragmentBegudesBinding

class BegudesFragment : Fragment() {

    private lateinit var binding : FragmentBegudesBinding
    private val begudesViewModel : BegudesVM by viewModels()
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        begudesViewModel.llistarBegudes(requireContext())

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_begudes, container, false)

        begudesViewModel.llistarBegudes(requireContext())

        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        val recyclerView = binding.begudesRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)


        begudesViewModel.llistat_begudes?.observe(viewLifecycleOwner, Observer { begudes ->
            val begudesAdapter = BegudesRecyclerViewAdapter(requireContext(),begudes, sharedViewModel)
            recyclerView.adapter = begudesAdapter
        })

        return binding.root
    }

}