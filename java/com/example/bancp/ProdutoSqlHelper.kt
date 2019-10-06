package com.example.bancp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ProdutoSqlHelper(context : Context)
    : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL((
                "CREATE TABLE $TABLE_NAME("+
                        "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        "$COLUMN_NAME TEXT NOT NULL, " +
                        "$COLUMN_VALUE REAL)")
                )
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}