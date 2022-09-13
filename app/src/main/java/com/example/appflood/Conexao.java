package com.example.appflood;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {
    private static final String name = "banco.db";
    private static final int version = 1;

    public Conexao(Context context) {super(context, name, null, version); }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE bairro (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome VARCHAR(255)," +
                "atingidos DOUBLE," +
                "id_cota INT" +
                ")");

        db.execSQL("CREATE TABLE cabeceiras_do_rio (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nivel DOUBLE," +
                "cidade VARCHAR (45)," +
                "hora_medicao DOUBLE," +
                "id_cota INT" +
                ")");

        db.execSQL("CREATE TABLE rio_taquari (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nivel  DOUBLE," +
                "hora_medicao DOUBLE," +
                "id_cota INT" +
                ")");

        db.execSQL("CREATE TABLE cotas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "cota_normal DOUBLE," +
                "cota_atencao DOUBLE," +
                "cota_alerta DOUBLE," +
                "cota_inundacao DOUBLE" +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE clientes ADD COLUMN telefone VARCHAR (45)");
    }
}

