package com.tantawy.eiad.comuneveiad.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tantawy.eiad.comuneveiad.MainActivity
import com.tantawy.eiad.comuneveiad.R
import com.tantawy.eiad.comuneveiad.models.Result

class PersonAdapter internal  constructor(val people: List<Result>, val context: MainActivity):
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonAdapter.PersonViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_person,
            parent,
            false
        )
        return PersonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonAdapter.PersonViewHolder, position: Int) {
        holder.top.text = people.get(position).person.first + " " + people.get(position).person.last
        holder.bottom.text = people.get(position).person.title
    }


    override fun getItemCount(): Int {
        return people.size
    }

    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val top : TextView = itemView.findViewById(R.id.top_tv)
        val bottom : TextView = itemView.findViewById(R.id.bottom_tv)
    }
}