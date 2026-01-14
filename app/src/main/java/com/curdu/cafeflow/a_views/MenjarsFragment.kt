package com.curdu.cafeflow.a_views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.curdu.cafeflow.R
import com.curdu.cafeflow.b_viewmodels.MenjarsVM
import com.curdu.cafeflow.b_viewmodels.SharedViewModel
import com.curdu.cafeflow.databinding.FragmentMenjarsBinding

class MenjarsFragment : Fragment() {

    private lateinit var binding: FragmentMenjarsBinding
    private val menjarsViewModel : MenjarsVM by viewModels()
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        menjarsViewModel.llistarMenjars(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menjars, container, false)

        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        menjarsViewModel.llistarMenjars(requireContext())

        val recyclerView = binding.menjarsRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        menjarsViewModel.llistat_menjars?.observe(viewLifecycleOwner, Observer { menjars ->
            val menjarsAdapter = MenjarRecyclerViewAdapter(requireContext(), menjars, sharedViewModel)
            recyclerView.adapter = menjarsAdapter
        })
        
        return binding.root
    }
}