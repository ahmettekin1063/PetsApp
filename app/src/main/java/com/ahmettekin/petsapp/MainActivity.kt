package com.ahmettekin.petsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    val tumDostlar = ArrayList<Pet>()
    lateinit var myAdapter:PetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureUI()
    }

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val searchView = menu?.findItem(R.id.app_bar_search)?.actionView as SearchView
        searchView.configureListener()
        return super.onCreateOptionsMenu(menu)
    }*/

    private fun veriKaynaginiDoldur() {
        val resimler = arrayOf(
            R.drawable.ani_cat_one,
            R.drawable.ani_cat_two,
            R.drawable.ani_cat_three,
            R.drawable.ani_cat_four,
            R.drawable.ani_cat_five,
            R.drawable.ani_cat_six,
            R.drawable.ani_cat_seven,

            R.drawable.ani_dog_one,
            R.drawable.ani_dog_two,
            R.drawable.ani_dog_three,
            R.drawable.ani_dog_four,
            R.drawable.ani_dog_five,

            R.drawable.ani_deer_one,
            R.drawable.ani_deer_two,
            R.drawable.ani_deer_three,
            R.drawable.ani_deer_four,

            R.drawable.bird_parrot_one,
            R.drawable.bird_parrot_two,
            R.drawable.bird_parrot_three,
            R.drawable.bird_parrot_four,
            R.drawable.bird_parrot_five,
            R.drawable.bird_parrot_six,
            R.drawable.bird_parrot_seven,
            R.drawable.bird_parrot_eight
        )
        val isimler = arrayOf(
            "Kedi 1",
            "Kedi 2",
            "Kedi 3",
            "Kedi 4",
            "Kedi 5",
            "Kedi 6",
            "Kedi 7",
            "Köpek 1",
            "Köpek 2",
            "Köpek 3",
            "Köpek 4",
            "Köpek 5",
            "Geyik 1",
            "Geyik 2",
            "Geyik 3",
            "Geyik 4",
            " Papagan 1",
            " Papagan 2",
            " Papagan 3",
            " Papagan 4",
            " Papagan 5",
            " Papagan 6",
            " Papagan 7",
            " Papagan 8"
        )

        for (i in resimler.indices) {
            val eklenecekDost = Pet(isimler[i], resimler[i])
            tumDostlar.add(eklenecekDost)
        }
    }

    private fun ArrayList<Pet>.search(newText: String): ArrayList<Pet> {
        val filteredItems = ArrayList<Pet>()

        for (temp in this) {
            if (temp.isim.toLowerCase().replace(" ", "").contains(newText.replace(" ", "").toLowerCase())) {
                filteredItems.add(temp)
            }
        }
        return filteredItems
    }

    private fun SearchView.configureListener(){
        this.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                //recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                //recyclerView.adapter = PetAdapter(filteredItems)
                /*val filteredItems = tumDostlar.search(newText!!)
                myAdapter setFilter filteredItems
                println("tetiklendi")*/
                myAdapter.filter.filter(newText)
                return false
            }
        })
    }

    /*private infix fun PetAdapter.setFilter(filteredItems:ArrayList<Pet>){
        petList=ArrayList()
        petList.addAll(filteredItems)
        notifyDataSetChanged()
    }*/

    private fun configureUI(){
        veriKaynaginiDoldur()
        myAdapter= PetAdapter(tumDostlar)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = myAdapter
        searchView.configureListener()
    }
}