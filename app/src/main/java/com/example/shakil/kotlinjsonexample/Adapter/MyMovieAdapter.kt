package com.example.shakil.kotlinjsonexample.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shakil.kotlinjsonexample.Model.Character
import com.example.shakil.kotlinjsonexample.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_movie_item.view.*

class CharacterAdapter(private val context: Context, private val characterList: MutableList<Character>): RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.layout_movie_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txt_characterName.text = characterList[position].name
        Picasso.get().load(characterList[position].img).into(holder.image)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image : ImageView
        var txt_characterName : TextView

        init {
            image = itemView.image_character
            txt_characterName = itemView.txt_CharacterName
        }
    }
}