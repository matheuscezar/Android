package com.example.bancp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.widget.TextView

class SQLiteRepository(ctx:Context) : ProdutoRepository {
    private val helper : ProdutoSqlHelper = ProdutoSqlHelper(ctx)
    private fun insert(produto: Produto){
        val db = helper.writableDatabase
        val cv = ContentValues().apply {
            put(COLUMN_NAME, produto.nome)
            put(COLUMN_VALUE,produto.valor)
        }
        val id = db.insert(TABLE_NAME, null, cv)
        if(id != -1L){
            produto.id = id
        }
        db.close()
    }

    private fun update (produto : Produto){
        val db = helper.writableDatabase
        val cv = ContentValues().apply {
            put(COLUMN_NAME, produto.nome)
            put(COLUMN_VALUE,produto.valor)
        }
        db.update(
            TABLE_NAME,cv, "COLUMN_ID = ?",
            arrayOf(produto.id.toString())
        )
        db.close()
    }
    override fun save(produto: Produto) {
        if(produto.id == 0L){
            insert((produto))
        }else{
            update(produto)
        }
    }

    override fun remove(vararg produtos: Produto) {
        val db = helper.writableDatabase
        for(produto in produtos){
            db.delete(
                TABLE_NAME,"$COLUMN_ID = ? ",
                arrayOf(produto.id.toString())
            )
        }
        db.close()
    }

    override fun produtoById(id: Long, callback: (Produto?) -> Unit) {
        val sql = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_ID = ?"
        val db = helper.writableDatabase
        val cursor = db.rawQuery(sql, arrayOf(id.toString()))
        val produto = if (cursor.moveToNext()) produtoFromCursosr(cursor) else null

        callback(produto)
    }

    override fun search(term: String, callback: (List<Produto>) -> Unit) {
        var sql = "SELECT * FROM $TABLE_NAME"
        var args : Array<String>? = null

        if(term.isNotEmpty()){
            sql += "WHERE $COLUMN_NAME LIKE ?"
            args = arrayOf(("%$term%"))
        }
        sql += " ORDER BY $COLUMN_NAME"
        val db = helper.readableDatabase
        val cursor = db.rawQuery(sql, args)
        val produtos = ArrayList<Produto>()
        while(cursor.moveToNext()){
            val produto = produtoFromCursosr(cursor)
            produtos.add(produto)
        }
        cursor.close()
        db.close()
        callback(produtos)
    }

    private fun produtoFromCursosr(cursor : Cursor) : Produto {
        val id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID))
        val nome = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
        val value = cursor.getFloat(cursor.getColumnIndex(COLUMN_VALUE))

        return Produto(id, nome, value)
    }


}