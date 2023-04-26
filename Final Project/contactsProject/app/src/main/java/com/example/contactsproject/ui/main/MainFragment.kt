package com.example.contactsproject.ui.main

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contactsproject.R
import android.widget.Toast

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactsproject.Contact
import androidx.fragment.app.viewModels
import com.example.contactsproject.databinding.CardLayoutBinding
import java.util.*
import com.example.contactsproject.databinding.FragmentMainBinding
import java.lang.Integer.parseInt


//class MainFragment : Fragment() implements {
class MainFragment : Fragment()  {


    private var adapter: ContactListAdapter? = null

    //priavate var



    companion object {
        fun newInstance() = MainFragment()
    }
    val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    //private var _binding2: CardLayoutBinding? = null
    //private val binding2 get() = _binding2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        listenerSetup()
        observerSetup()
        recyclerSetup()
        return binding.root

    }

    private fun clearFields() {
        binding.ContactID.text = ""
        binding.NameEntry.setText("")
        binding.phoneNumber.setText("")
    }
    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            var name = binding.NameEntry.text.toString()
            var phoneNum = binding.phoneNumber.text.toString()
            Toast.makeText(context,"placeholder",Toast.LENGTH_LONG)
            if (name != "" && phoneNum != "") {
                val contact = Contact(name, phoneNum)
                viewModel.insertContact(contact)
                clearFields()
            } else {
                val toast = Toast.makeText(context, "INVALID, please enter both a name and phone number", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.LEFT,200,200)
                toast.show()
            }
        }
        binding.findButton.setOnClickListener {
            viewModel.findContact(
                binding.NameEntry.text.toString())
        }
       /* binding.deleteButton.setOnClickListener {
            viewModel.deleteContact(binding.NameEntry.text.toString())
            clearFields()
        }*/

        /*binding2?.trashCan?.setOnClickListener {

            viewModel.deleteContact(binding.ContactID.text.toString())
            clearFields()

        }*/
        binding.acsendingButton.setOnClickListener {
            viewModel.sortAcending()

        }
        binding.descendButton.setOnClickListener {
            viewModel.sortDecending()
        }
        //binding.contactLayout.setonClickListener{
            //viewModel.deleteContact()
       // }
    }



    private fun observerSetup() {
        viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        })
        viewModel.getSearchResults()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                    //observerSetup()
                } else {
                    Toast.makeText(context, "placeHolder", Toast.LENGTH_LONG)
                    val toast = Toast.makeText(context, "INVALID DATA please enter the name or character of an existing contact",
                        Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.LEFT,200,200)
                    toast.show()

                }
            }
        })
    }
    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.card_layout)
        binding.contactLayout.layoutManager = LinearLayoutManager(context)
        binding.contactLayout.adapter = adapter

        adapter!!.settingListener(object: ContactListAdapter.onItemClickListener{
            override fun onItemClick(id: String) {
                var contactId: Int = parseInt(id)
                viewModel.deleteContact(contactId)
            }
        })

    }
}