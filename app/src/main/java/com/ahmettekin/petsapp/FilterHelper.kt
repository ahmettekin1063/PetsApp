package com.ahmettekin.petsapp

import android.widget.Filter

class FilterHelper(val petList: ArrayList<Pet>, val adapter: PetAdapter) : Filter() {

    override fun performFiltering(constraint: CharSequence?): FilterResults {

        val sonuc =FilterResults()

        if (constraint != null && constraint.isNotEmpty()) {
            val aranilanAd = constraint.toString().toLowerCase()
            val eslesenler=ArrayList<Pet>()
            for(dost in petList){
                val adi=dost.isim.toLowerCase()
                if(adi.contains(aranilanAd.toString())) {
                    eslesenler.add(dost)
                }
            }
            sonuc.values = eslesenler
            sonuc.count =eslesenler.size
        }else {
            sonuc.values=petList
            sonuc.count = petList.size
        }
        return sonuc
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        adapter.setFilter(results?.values as ArrayList<Pet>)
        adapter.notifyDataSetChanged()
    }
}