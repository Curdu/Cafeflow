package com.curdu.cafeflow.a_views

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.curdu.cafeflow.c_models.entitats.Comanda
import com.curdu.cafeflow.databinding.HistorialCardBinding

class HistorialRecyclerViewAdapter(val context: Context,val historial : List<Comanda>) : RecyclerView.Adapter<HistorialRecyclerViewAdapter.HistorialViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistorialViewHolder {
        val binding = HistorialCardBinding.inflate(LayoutInflater.from(context), parent, false);
        return HistorialViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: HistorialViewHolder,
        position: Int
    ) {
        holder.preu.text = "${historial[position].preuTotal} €"
        holder.numero.text = "${position+1}"
    }

    override fun getItemCount(): Int {
        return historial.size
    }


    class HistorialViewHolder(var view: HistorialCardBinding) : RecyclerView.ViewHolder(view.root) {
        var preu : TextView = view.preuComandaText
        var numero : TextView = view.numeroComandaText
    }
}