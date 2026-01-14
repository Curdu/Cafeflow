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
import com.curdu.cafeflow.c_models.entitats.Menjar
import com.curdu.cafeflow.databinding.MenjarCardBinding
import com.squareup.picasso.Picasso

class MenjarRecyclerViewAdapter(val context: Context, val menjar: List<Menjar>, var sharedViewModel: SharedViewModel)
    : RecyclerView.Adapter<MenjarRecyclerViewAdapter.MenjarViewHolder>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenjarViewHolder {

        val binding = MenjarCardBinding.inflate(LayoutInflater.from(context), parent, false);
        return MenjarViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MenjarViewHolder,
        position: Int
    ) {
        val menjar = menjar[position]
        Picasso.get()
            .load(menjar.imgUrl)
            .placeholder(R.drawable.outline_fastfood_24)
            .into(holder.imatge)
        holder.titol.text = menjar.nom
        holder.preu.text = "${menjar.preu}€"
        holder.vegeta.text = if(menjar.esVegetaria) "Vegetarià" else "No vegetarià"
        holder.ingredients.text = menjar.ingredients

        holder.boto.setOnClickListener{
            sharedViewModel.afegirProducte(menjar)
            Toast.makeText(context, "Menjar afegida correctament", Toast.LENGTH_LONG).show()
            Log.println(Log.INFO, "Menjar", menjar.toString())
        }
    }

    override fun getItemCount(): Int {
        return menjar.size
    }

    inner class MenjarViewHolder(var view: MenjarCardBinding) : RecyclerView.ViewHolder(view.root) {
        var imatge : ImageView = view.menjarImageView
        var titol : TextView = view.titolMenjarText
        var preu : TextView = view.preuMenjarText
        var vegeta : TextView = view.vegetaMenjarText
        var ingredients : TextView = view.ingredientsMenjarText
        var boto : Button = view.afegirMenjarButton

    }
}