package com.example.appflood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class RioTaquariDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public RioTaquariDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(RioTaquariModel model) {
        ContentValues values = new ContentValues();
        values.put("id", model.getId());
        values.put("nivel", model.getNivel());
        values.put("hora_medicao", model.getHora_medicao());
        values.put("id_cota", model.getId_cota());

        // Retorna o id do registro inserido
        return banco.insert("rio_taquari", null, values);
    }

    public ArrayList<RioTaquariModel> listar() {
        ArrayList<RioTaquariModel> lista = new ArrayList<>();
        Cursor cursor = banco.query("rio_taquari", new String[]{"id", "nivel", "hora_medicao", "id_cota"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            RioTaquariModel model = new RioTaquariModel();
            model.setId(cursor.getInt(0));
            model.setNivel(Double.parseDouble(cursor.getString(1)));
            model.setHora_medicao(Double.parseDouble(cursor.getString(2)));
            model.setId_cota(cursor.getInt(3));
            lista.add(model);
        }

        return lista;
    }

    public RioTaquariModel ler(int id) {
        RioTaquariModel model = new RioTaquariModel();
        Cursor cursor = banco.query("rio_taquari", new String[]{"id", "nivel", "hora_medicao", "id_cota"}, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        while (cursor.moveToNext()) {
            model.setId(cursor.getInt(0));
            model.setNivel(Double.parseDouble(cursor.getString(1)));
            model.setHora_medicao(Double.parseDouble(cursor.getString(2)));
            model.setId_cota(cursor.getInt(3));
        }
        return model;
    }

    public long atualizar(RioTaquariModel model) {
        ContentValues values = new ContentValues();
        values.put("id", model.getId());
        values.put("nivel", model.getNivel());
        values.put("hora_medicao", model.getHora_medicao());
        values.put("id_cota", model.getId_cota());

        // Retorna o id do registro atualizado
        return banco.update("rio_taquari", values, "id = ?", new String[]{String.valueOf(model.getId())});
    }

    public int excluir(RioTaquariModel model) {
        return banco.delete("rio_taquari", "id = ?", new String[]{String.valueOf(model.getId())});
    }
}
