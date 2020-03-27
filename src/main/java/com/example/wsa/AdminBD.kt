/*
    No. Control: 17981466
    Alumno: Jesus Adrian Camacho Rocha.
    Materia: Desarrollo de Aplicaciones Moviles.
    Profesor: Alejandro Guzman Zazueta.
 */

package com.example.wsa

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

class AdminBD(context: Context) : SQLiteOpenHelper(context, "Sensado", null, 1) {
    override fun onCreate(bd: SQLiteDatabase?) {
        bd?.execSQL(
            "Create Table sensado(" +
                    "idsen INTEGER NOT NULL primary key," +
                    "nomsensor TEXT," +
                    "valor INTEGER)"
        )
    }

    // Insert, Update or Delete
    fun Ejecuta(sentencia: String): Boolean {
        try {
            val bd = this.writableDatabase
            bd.execSQL(sentencia)
            bd.close()
            return true
        } catch (ex: Exception) {
            return false
        }
    }

    //Query
    fun Consulta(query: String): Cursor? {
        try {
            val bd = this.readableDatabase
            return bd.rawQuery(query, null)
        } catch (ex: Exception) {
            return null
        }
    }

    override fun onUpgrade(bd: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}