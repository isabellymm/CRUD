package com.example.crud.repository

import android.content.ContentValues
import android.content.Context
import com.example.crud.GuestDataBase
import com.example.crud.GuestModel
import com.example.crud.constants.DataBaseConstants
import java.lang.Exception


class GuestRepository private constructor(context: Context){

    private val guestDataBase = GuestDataBase(context)

    companion object{
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if (!::repository.isInitialized){
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun insert(guest: GuestModel): Boolean{
       return try {
           val db = guestDataBase.writableDatabase


           val values = ContentValues()
           values.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
           values.put(DataBaseConstants.GUEST.COLUMNS.PRICE, guest.price)
           values.put(DataBaseConstants.GUEST.COLUMNS.STOCK, guest.stock)
           values.put(DataBaseConstants.GUEST.COLUMNS.CATEGORY,guest.category)

           db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, values )
           true

       }catch (e: Exception){
           false

       }
    }
}