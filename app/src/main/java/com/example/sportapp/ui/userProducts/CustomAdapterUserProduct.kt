package com.example.sportapp.ui.userProducts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.sportapp.R
import com.example.sportapp.responses.UserProductResponse
import com.example.sportapp.responses.UserServiceResponse
import com.example.sportapp.ui.userServices.CustomAdapterUserService

internal class CustomAdapterUserProduct(private var itemsList: List<UserProductResponse.Result>) :
    RecyclerView.Adapter<CustomAdapterUserProduct.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemNameView: TextView = view.findViewById(R.id.nameItemProduct)
        var itemDesciptionView: TextView = view.findViewById(R.id.descriptionItemProduct)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.itemNameView.text = item.name
        holder.itemDesciptionView.text = item.description
    }
    override fun getItemCount(): Int {
        return itemsList.size
    }
}