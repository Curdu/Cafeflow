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
import com.curdu.cafeflow.b_viewmodels.PostresVM
import com.curdu.cafeflow.b_viewmodels.SharedViewModel
import com.curdu.cafeflow.databinding.FragmentPostresBinding

class PostresFragment : Fragment() {
    
    private lateinit var binding: FragmentPostresBinding
    private val postresViewModel : PostresVM by viewModels()
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postresViewModel.llistarPostres(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_postres, container, false)
        
        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        postresViewModel.llistarPostres(requireContext())

        val recyclerView = binding.postresRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        postresViewModel.llistat_postres?.observe(viewLifecycleOwner, Observer { postres ->
            val postresAdapter = PostreRecyclerViewAdapter(requireContext(), postres, sharedViewModel)
            recyclerView.adapter = postresAdapter
        })
        
        return binding.root
    }
}