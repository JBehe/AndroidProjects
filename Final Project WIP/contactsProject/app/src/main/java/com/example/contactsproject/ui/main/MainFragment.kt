package com.example.contactsproject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contactsproject.R

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactsproject.Contact
import androidx.fragment.app.viewModels
import java.util.*
import com.example.contactsproject.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var adapter: ContactListAdapter? = null

    //priavate var



    companion object {
        fun newInstance() = MainFragment()
    }
    val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


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
       // binding.ContactID.text = ""
        binding.NameEntry.setText("")
        binding.phoneNumber.setText("")
    }
    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            var name = binding.NameEntry.text.toString()
            var phoneNum = binding.phoneNumber.text.toString()
           // var phoneNum = binding.phoneNumber.text.toString()
            if (name != "" && phoneNum != "") {
                val contact = Contact(name, Integer.parseInt(phoneNum))
                viewModel.insertContact(contact)
                clearFields()
            } else {
                name = "Incomplete information"
            }
        }
        binding.findButton.setOnClickListener {
            viewModel.findContact(
                binding.NameEntry.text.toString())
        }
        binding.deleteButton.setOnClickListener {
            viewModel.deleteContact(binding.NameEntry.text.toString())
            clearFields()
        }
        binding.acsendingButton.setOnClickListener {
            viewModel.sortAcending()
        }
        binding.descendButton.setOnClickListener {
            viewModel.sortDecending()
        }
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
                    binding.ContactID.text = String.format(Locale.US, "%d", it[0].id)
                    binding.NameEntry.setText(it[0].contactName)
                    binding.phoneNumber.setText(String.format(Locale.US, "%d", it[0].phoneNumber))
                } else {
                    binding.ContactID.text = "No Match"
                }
            }
        })
    }
    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.card_layout)
        binding.contactLayout.layoutManager = LinearLayoutManager(context)
        binding.contactLayout.adapter = adapter
    }
}