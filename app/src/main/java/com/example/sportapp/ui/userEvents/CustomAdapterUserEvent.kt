package com.example.sportapp.ui.userEvents

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.sportapp.R
import com.example.sportapp.responses.UserEventResponse
import com.example.sportapp.responses.UserServiceResponse
import com.example.sportapp.ui.userServices.CustomAdapterUserService

internal class CustomAdapterUserEvent(private var itemsList: List<UserEventResponse.Result>) :
    RecyclerView.Adapter<CustomAdapterUserEvent.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemNameView: TextView = view.findViewById(R.id.nameItem)
        var itemDesciptionView: TextView = view.findViewById(R.id.descriptionItem)
        var itemDateView: TextView = view.findViewById(R.id.dateItem)
        var itemCityView: TextView = view.findViewById(R.id.cityItem)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_event, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.itemNameView.text = item.name
        holder.itemDesciptionView.text = item.description
        holder.itemDateView.text = item.date
        holder.itemCityView.text = item.city
    }
    override fun getItemCount(): Int {
        return itemsList.size
    }
}