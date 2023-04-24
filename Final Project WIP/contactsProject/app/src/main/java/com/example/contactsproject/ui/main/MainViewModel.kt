package com.example.contactsproject.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.contactsproject.Contact
import com.example.contactsproject.ContactRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ContactRepository = ContactRepository(application)
    private var allContacts: LiveData<List<Contact>>? = repository.allContacts
    private val searchResults: MutableLiveData<List<Contact>>

    init {
        searchResults = repository.searchResults
    }
    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
    }
    fun findContact(name: String) {
        repository.findContact(name)
    }
    fun deleteContact(name: String) {
        repository.deleteContact(name)
    }
    fun sortAcending(){
        //repository.sortAcending(allContacts)
        repository.sortAcending()
        repository.allContacts = getAllContacts()
    }
    fun sortDecending(){
        repository.sortDecending()
    }

    fun getSearchResults(): MutableLiveData<List<Contact>>? {
        return searchResults
    }
    fun getAllContacts(): LiveData<List<Contact>>? {
        return allContacts
    }
}