package com.curdu.cafeflow.a_views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.curdu.cafeflow.R
import com.curdu.cafeflow.b_viewmodels.SharedViewModel
import com.curdu.cafeflow.databinding.FragmentTotalBinding

class TotalFragment : Fragment() {

    lateinit var  binding : FragmentTotalBinding
    lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_total, container, false)
        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        val recyclerView = binding.totalRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        sharedViewModel.llistatProductes.observe(viewLifecycleOwner,Observer { productes ->
            val adapter = TotalRecyclerViewAdapter(requireContext(), productes, sharedViewModel)
            recyclerView.adapter = adapter
            productes.forEach { producte -> Log.println(Log.INFO, "Total", producte.toString()) }
        })

        binding.pagatTotalButton.setOnClickListener {
            sharedViewModel.pagarComanda(requireContext())

        }

        return binding.root
    }

}