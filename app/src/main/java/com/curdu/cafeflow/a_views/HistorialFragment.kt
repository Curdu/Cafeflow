package com.curdu.cafeflow.a_views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.curdu.cafeflow.R
import com.curdu.cafeflow.b_viewmodels.HistorialVM
import com.curdu.cafeflow.databinding.FragmentHistorialBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HistorialFragment : Fragment() {

    private lateinit var binding : FragmentHistorialBinding
    private val historialVM: HistorialVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            historialVM.refrescarHistorial(Firebase.auth.uid.toString())
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        CoroutineScope(Dispatchers.IO).launch {
            historialVM.refrescarHistorial(Firebase.auth.uid.toString())
        }
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_historial, container, false)
        val recyclerView = binding.historialRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)


        historialVM.historial.observe(viewLifecycleOwner, Observer {historial ->
            val historialAdapter = HistorialRecyclerViewAdapter(requireContext(), historial)
            recyclerView.adapter = historialAdapter
        })
        // Inflate the layout for this fragment
        return binding.root
    }

}