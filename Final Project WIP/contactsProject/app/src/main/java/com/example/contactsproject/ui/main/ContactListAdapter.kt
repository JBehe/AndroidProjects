package com.example.contactsproject.ui.main


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsproject.Contact
import com.example.contactsproject.R

class ContactListAdapter (private val contactItemLayout: Int) :  RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {
    private var contactList: List<Contact>? = null

    var listener: onItemClickListener?= null

    fun settingListener(listener: onItemClickListener?){
        this.listener = listener
    }


    interface onItemClickListener {
        fun onClick(str: String)
    }

    /*private lateinit var onListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        onListener = listener

    }*/
    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val nm = holder.name
        val num = holder.number
        var trashCan = holder.trashCan
        //var contactId = holder.id

        /*holder.itemView.setOnClickListener{

        }*/
        /* this is the palceholder for the delete on the trashcan
        holder.itemView.setOnClickListener(view -> {

        }
        //holder.itemView.setOnClickListener(){
 */

       // }
       // val item2 = holder.item2
        contactList.let {
            nm.text = it!![listPosition].contactName
            num.text = it!![listPosition].phoneNumber
            //contactId.text = it!![listPosition].id.toString()

        }

        trashCan.setOnClickListener {
            //var id = contactId.text.toString()
            //listener?.onClick(id)
            Log.i("zzzz","trash can works")

            //listener.onClick(id)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false)
        return ViewHolder(view)
        //return ViewHolder(view,onListener)
    }
    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.contactRow)
        var number: TextView = itemView.findViewById(R.id.numberRow)
        var trashCan: ImageView = itemView.findViewById(R.id.trashCan)
       // var id: TextView = itemView.findViewById(R.id.ContactID)
        //init{
           /* class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }*/

        //}
        //var itemView: TextView = itemView.findViewById(R.id.imageView)
    }

}