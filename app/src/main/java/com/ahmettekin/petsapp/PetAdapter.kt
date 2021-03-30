package com.ahmettekin.petsapp

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tek_uye.view.*

class PetAdapter(var petList: ArrayList<Pet>) : RecyclerView.Adapter<PetAdapter.MyViewHolder>(), Filterable {

    val myFilter = FilterHelper(petList, this)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.tek_uye, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.petIsım.text = petList[position].isim
        holder.itemView.petResim.setImageResource(petList[position].resim)
        holder.itemView.setOnClickListener {}

        val bitmap =
            BitmapFactory.decodeResource(holder.itemView.resources, petList[position].resim)

        Palette.from(bitmap).generate {
            val vibrantColor: Int = it!!.getVibrantColor(R.attr.colorAccent)
            holder.itemView.setBackgroundColor(vibrantColor)
        }
    }

    override fun getItemCount(): Int {
        return petList.size
    }

    /*fun setFilter(filteredItems: ArrayList<Pet>) {
        petList=ArrayList()
        petList.addAll(filteredItems)
        notifyDataSetChanged()
    }*/

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getFilter(): Filter {
        return myFilter
    }

    fun setFilter(arrayList: ArrayList<Pet>) {
        petList = arrayList
    }
}