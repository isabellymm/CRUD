package com.example.crud

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.crud.repository.GuestRepository

class GuestFromViewModel(application: Application): AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    fun insert(guest: GuestModel){
        repository.insert(guest)
    }
}