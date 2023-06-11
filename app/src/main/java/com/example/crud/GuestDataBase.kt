package com.example.crud

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.crud.constants.DataBaseConstants


class GuestDataBase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {


    companion object{
        private const val NAME = "guestdb"
        private const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE " + DataBaseConstants.GUEST.TABLE_NAME + " (" +
                DataBaseConstants.GUEST.COLUMNS.ID+ " integer primary key autoincrement," +
                DataBaseConstants.GUEST.COLUMNS.NAME+ " text, " +
                DataBaseConstants.GUEST.COLUMNS.PRICE+ " float," +
                DataBaseConstants.GUEST.COLUMNS.STOCK+"  int," +
                DataBaseConstants.GUEST.COLUMNS.CATEGORY+" text);")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}