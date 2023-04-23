package com.example.contactsproject.ui.main


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsproject.Contact
import com.example.contactsproject.R

class ContactListAdapter (private val contactItemLayout: Int) :  RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {
    private var contactList: List<Contact>? = null
    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val item = holder.item
       // val item2 = holder.item2
        contactList.let {
            item.text = it!![listPosition].contactName
           // item2.text = it!![listPosition].phoneNumber.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false)
        return ViewHolder(view)
    }
    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item: TextView = itemView.findViewById(R.id.contactRow)
       //b var item2: TextView = itemView.findViewById(R.id.phoneNumber)
    }

}