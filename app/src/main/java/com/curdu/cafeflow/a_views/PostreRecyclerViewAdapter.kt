package com.curdu.cafeflow.a_views


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.curdu.cafeflow.R
import com.curdu.cafeflow.b_viewmodels.SharedViewModel
import com.curdu.cafeflow.c_models.entitats.Postre
import com.curdu.cafeflow.databinding.PostreCardBinding
import com.squareup.picasso.Picasso

class PostreRecyclerViewAdapter(val context: Context, val postre: List<Postre>, var sharedViewModel: SharedViewModel)
    : RecyclerView.Adapter<PostreRecyclerViewAdapter.PostreViewHolder>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostreViewHolder {

        val binding = PostreCardBinding.inflate(LayoutInflater.from(context), parent, false);
        return PostreViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PostreViewHolder,
        position: Int
    ) {
        val postre = postre[position]
        Picasso.get()
            .load(postre.imgUrl)
            .placeholder(R.drawable.outline_fastfood_24)
            .into(holder.imatge)
        holder.titol.text = postre.nom
        holder.preu.text = "${postre.preu}€"
        holder.casola.text = if(postre.esCasola) "Vegetarià" else "No vegetarià"
        holder.calories.text = "${postre.calories} kcal"

        holder.boto.setOnClickListener{
            sharedViewModel.afegirProducte(postre)
            Toast.makeText(context, "Postre afegida correctament", Toast.LENGTH_LONG).show()
            Log.println(Log.INFO, "Postre", postre.toString())
        }
    }

    override fun getItemCount(): Int {
        return postre.size
    }

    inner class PostreViewHolder(var view: PostreCardBinding) : RecyclerView.ViewHolder(view.root) {
        var imatge : ImageView = view.postreImageView
        var titol : TextView = view.titolPostreText
        var preu : TextView = view.preuPostreText
        var casola : TextView = view.casolaPostreText
        var calories : TextView = view.caloriesPostreText
        var boto : Button = view.afegirPostreButton

    }
}