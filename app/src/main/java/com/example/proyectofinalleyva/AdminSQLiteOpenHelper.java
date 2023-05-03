package com.example.proyectofinalleyva;

//librerias de conexion a BD SQLite

import  android.database.sqlite.SQLiteDatabase; //abre la base de datos SQLite
import  android.database.sqlite.SQLiteDatabase.CursorFactory; //produce instrucciones SQL
import  android.database.sqlite.SQLiteOpenHelper; //Gestiona los datos desde la aplicación
import  android.content.Context;//Donde compila y ejecuta

import androidx.annotation.Nullable;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    //constructor que se conecta a la base de datos y genera datos

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Crea tabla en base de datos administracion
        db.execSQL("create table articulo (cod integer primary key, nombre text, existencia integer )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists articulo");
        db.execSQL("create table articulo (cod integer primary key, nombre text, existencia integer )");
    }//inicia clase

}
