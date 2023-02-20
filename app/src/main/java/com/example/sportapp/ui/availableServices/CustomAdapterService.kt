package com.example.sportapp.ui.availableServices

import com.example.sportapp.R
import com.example.sportapp.responses.ServiceResponse
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

internal class CustomAdapterService(private var itemsList: List<ServiceResponse.Result>) :
    RecyclerView.Adapter<CustomAdapterService.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemNameView: TextView = view.findViewById(R.id.nameItem)
        var itemDesciptionView: TextView = view.findViewById(R.id.descriptionItem)
        var itemPriceView: TextView = view.findViewById(R.id.itemPrice)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.itemNameView.text = item.name
        holder.itemDesciptionView.text = item.description
        holder.itemPriceView.text = item.price.toString()
    }
    override fun getItemCount(): Int {
        return itemsList.size
    }
}