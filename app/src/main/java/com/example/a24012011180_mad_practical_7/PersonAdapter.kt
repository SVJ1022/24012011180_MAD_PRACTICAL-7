package com.example.a24012011180_mad_practical_7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate

class PersonAdapter(val contactList: Array<Person>):
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>(){
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): PersonViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.single_item,parent,false)
            return PersonViewHolder(itemView)
        }

    override fun onBindViewHolder(
        holder: PersonViewHolder,
        position:Int
    ){
        val contact = contactList[position]
        holder.tvContactName.text = contact.name
        holder.tvPhone.text = contact.phoneNo
        holder.tvEmail.text = contact.emailId
        holder.tvAdd.text = contact.address
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    class PersonViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvContactName: TextView = itemView.findViewById<TextView>(R.id.contact_name)
        val tvPhone: TextView = itemView.findViewById<TextView>(R.id.phone)
        val tvEmail: TextView = itemView.findViewById<TextView>(R.id.email)
        val tvAdd: TextView = itemView.findViewById<TextView>(R.id.address)
    }
}