package com.curdu.cafeflow.a_views

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.curdu.cafeflow.R
import com.curdu.cafeflow.b_viewmodels.SharedViewModel
import com.curdu.cafeflow.c_models.entitats.Beguda
import com.curdu.cafeflow.databinding.BegudaCardBinding
import com.squareup.picasso.Picasso

class BegudesRecyclerViewAdapter(val context: Context, val begudes: List<Beguda>, var sharedViewModel: SharedViewModel)
    : RecyclerView.Adapter<BegudesRecyclerViewAdapter.BegudaViewHolder>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BegudaViewHolder {

        val binding = BegudaCardBinding.inflate(LayoutInflater.from(context), parent, false);
        return BegudaViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: BegudaViewHolder,
        position: Int
    ) {
        val beguda = begudes[position]
        Picasso.get()
            .load(beguda.imgUrl)
            .placeholder(R.drawable.outline_beer_meal_24)
            .into(holder.imatge)
        holder.titol.text = beguda.nom
        holder.preu.text = "${beguda.preu}€"
        holder.volum.text = "${beguda.capacitat} cl"

        holder.boto.setOnClickListener{
            sharedViewModel.afegirProducte(beguda)
            Toast.makeText(context, "Beguda afegida correctament", Toast.LENGTH_LONG).show()
            Log.println(Log.INFO, "Beguda", beguda.toString())
        }
    }

    override fun getItemCount(): Int {
        return begudes.size
    }

    inner class BegudaViewHolder(var view: BegudaCardBinding) : RecyclerView.ViewHolder(view.root) {
        var imatge : ImageView = view.begudaImageView
        var titol : TextView = view.titolBegudaText
        var preu : TextView = view.preuBegudaText
        var volum : TextView = view.volumBegudaText
        var boto : Button = view.afegirBegudaButton

    }
}