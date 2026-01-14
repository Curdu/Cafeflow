package com.curdu.cafeflow.a_views

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.curdu.cafeflow.R
import com.curdu.cafeflow.b_viewmodels.SharedViewModel
import com.curdu.cafeflow.c_models.entitats.Producte
import com.curdu.cafeflow.databinding.ProducteCardBinding
import com.squareup.picasso.Picasso


class TotalRecyclerViewAdapter(val context: Context, val productes: List<Producte>, var sharedViewModel: SharedViewModel)
    : RecyclerView.Adapter<TotalRecyclerViewAdapter.TotalViewHolder>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TotalViewHolder {

        val binding = ProducteCardBinding.inflate(LayoutInflater.from(context), parent, false);
        return TotalViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: TotalViewHolder,
        position: Int
    ) {
        val producte = productes[position]
        Picasso.get()
            .load(producte.imgUrl)
            .placeholder(R.drawable.outline_add_shopping_cart_24)
            .into(holder.imatge)
        holder.titol.text = producte.nom
        holder.preu.text = "${producte.preu}€"

        holder.boto.setOnClickListener {
            sharedViewModel.eliminarProducte(productes[position])
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, productes.size)
        }

    }

    override fun getItemCount(): Int {
        return productes.size
    }

    inner class TotalViewHolder(var view: ProducteCardBinding) : RecyclerView.ViewHolder(view.root) {
        var imatge : ImageView = view.producteImageView
        var titol : TextView = view.titolProducteText
        var preu : TextView = view.preuProducteText
        var boto : Button = view.eliminarProducteButton

    }
}