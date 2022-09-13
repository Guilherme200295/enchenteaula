package com.example.appflood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class BairroDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public BairroDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(BairroModel model) {
        ContentValues values = new ContentValues();
        values.put("id", model.getId());
        values.put("nome", model.getNome());
        values.put("atingidos", model.getAtingidos());
        values.put("id_cota", model.getId_cota());

        // Retorna o id do registro inserido
        return banco.insert("bairro", null, values);
    }

    public ArrayList<BairroModel> listar() {
        ArrayList<BairroModel> lista = new ArrayList<>();
        Cursor cursor = banco.query("bairro", new String[]{"id", "nome", "atingidos", "id_cota"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            BairroModel model = new BairroModel();
            model.setId(cursor.getInt(0));
            model.setNome(cursor.getString(1));
            model.setAtingidos(Double.parseDouble(cursor.getString(2)));
            model.setId_cota(cursor.getInt(3));
            lista.add(model);
        }

        return lista;
    }

    public BairroModel ler(int id) {
        BairroModel model = new BairroModel();
        Cursor cursor = banco.query("bairro", new String[]{"id", "nome", "atingidos", "id_cota"}, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        while (cursor.moveToNext()) {
            model.setId(cursor.getInt(0));
            model.setNome(cursor.getString(1));
            model.setAtingidos(Double.parseDouble(cursor.getString(2)));
            model.setId_cota(cursor.getInt(3));
        }
        return model;
    }

    public long atualizar(BairroModel model) {
        ContentValues values = new ContentValues();
        values.put("id", model.getId());
        values.put("nome", model.getNome());
        values.put("atingidos", model.getAtingidos());
        values.put("id_cota", model.getId_cota());

        // Retorna o id do registro atualizado
        return banco.update("bairro", values, "id = ?", new String[]{String.valueOf(model.getId())});
    }

    public int excluir(BairroModel model) {
        return banco.delete("bairro", "id = ?", new String[]{String.valueOf(model.getId())});
    }
}

