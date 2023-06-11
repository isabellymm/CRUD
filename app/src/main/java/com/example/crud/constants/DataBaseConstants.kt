package com.example.crud.constants

class DataBaseConstants private constructor(){

     object GUEST{
        const val TABLE_NAME = "Guest"


         object COLUMNS{
             const val ID = "id"
             const val NAME = "name"
             const val  PRICE = "price"
             const val STOCK = "stock"
             const val CATEGORY = "category"

         }

    }

}