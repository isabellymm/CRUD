package com.example.crud

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.example.crud.BD_Crud.FeedReaderContract.FeedEntry.NOME_BANCO
import com.example.crud.BD_Crud.FeedReaderContract.FeedEntry.SQL_CREATE_ENTRIES
import com.example.crud.BD_Crud.FeedReaderContract.FeedEntry.SQL_DELETE_ENTRIES
import com.example.crud.BD_Crud.FeedReaderContract.FeedEntry.TABELA
import com.example.crud.BD_Crud.FeedReaderContract.FeedEntry.VERSAO


class BD_Crud  {

    object FeedReaderContract {
        // Table contents are grouped together in an anonymous object.
        object FeedEntry : BaseColumns {
            const val NOME_BANCO = "banco.db"
            const val TABELA = "CRUD_Produtos"
            const val ID = "id"
            const val NOME_PRODUTO = "nome"
            const val PRECO = "preco"
            const val ESTOQUE = "estoque"
            const val CATEGORIA = "categoria"
            const val VERSAO = 1


            val SQL_CREATE_ENTRIES =
                "CREATE TABLE " + FeedEntry.TABELA + " (" + BaseColumns._ID + " integer primary key autoincrement, " +
                        FeedEntry.NOME_PRODUTO + " text, " + FeedEntry.PRECO + " text, " + FeedEntry.ESTOQUE + " text, " +
                        FeedEntry.CATEGORIA + " text)"

            val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABELA"
        }
    }



    class FeedReaderDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(SQL_CREATE_ENTRIES)

        }


        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES)
            onCreate(db)
        }


        override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            onUpgrade(db, oldVersion, newVersion)
        }
        companion object {
            // If you change the database schema, you must increment the database version.
            const val DATABASE_VERSION = VERSAO
            const val DATABASE_NAME = NOME_BANCO
        }

    }



}