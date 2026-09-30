package com.example.a24012011180_mad_practical_7

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
import com.google.android.material.card.MaterialCardView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PersonAdapter(val contactList: ArrayList<Person>, var db: DatabaseHelper):
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
            holder.mainCard.setOnClickListener {
                val intent = Intent(holder.itemView.context, EditActivity::class.java)
                intent.putExtra("person_id", contact.id)
                holder.itemView.context.startActivity(intent)
            }
            holder.deleteButton.setOnClickListener {

                val currentPosition = holder.bindingAdapterPosition

                if (currentPosition != RecyclerView.NO_POSITION) {

                    val person = contactList[currentPosition]

                    db.deleteContact(person.id)

                    contactList.removeAt(currentPosition)

                    notifyItemRemoved(currentPosition)
                }
            }
        }

        override fun getItemCount(): Int {
            return contactList.size
        }

        class PersonViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
            val tvContactName: TextView = itemView.findViewById<TextView>(R.id.contact_name)
            val tvPhone: TextView = itemView.findViewById<TextView>(R.id.phone)
            val tvEmail: TextView = itemView.findViewById<TextView>(R.id.email)
            val tvAdd: TextView = itemView.findViewById<TextView>(R.id.address)
            val mainCard: MaterialCardView = itemView.findViewById(R.id.mainCard)
            val deleteButton: FloatingActionButton = itemView.findViewById(R.id.delete_btn)
        }
}