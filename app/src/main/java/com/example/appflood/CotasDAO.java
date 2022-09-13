package com.example.appflood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CotasDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public CotasDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(CotasModel model) {
        ContentValues values = new ContentValues();
        values.put("id", model.getId());
        values.put("cota_normal", model.getCota_normal());
        values.put("cota_atencao", model.getCota_atencao());
        values.put("cota_alerta", model.getCota_alerta());
        values.put("cota_inudacao", model.getCota_inundacao());

        // Retorna o id do registro inserido
        return banco.insert("cotas", null, values);
    }

    public ArrayList<CotasModel> listar() {
        ArrayList<CotasModel> lista = new ArrayList<>();
        Cursor cursor = banco.query("cotas", new String[]{"id", "cota_normal", "cota_atencao", "cota_alerta", "cota_inundacao"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            CotasModel model = new CotasModel();
            model.setId(cursor.getInt(0));
            model.setCota_normal(Double.parseDouble(cursor.getString(1)));
            model.setCota_atencao(Double.parseDouble(cursor.getString(2)));
            model.setCota_alerta(Double.parseDouble(cursor.getString(3)));
            model.setCota_inundacao(Double.parseDouble(cursor.getString(4)));
            lista.add(model);
        }

        return lista;
    }

    public CotasModel ler(int id) {
        CotasModel model = new CotasModel();
        Cursor cursor = banco.query("cotas", new String[]{"id","cota_normal", "cota_atencao", "cota_alerta", "cota_inundacao"}, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        while (cursor.moveToNext()) {
            model.setId(cursor.getInt(0));
            model.setCota_normal(Double.parseDouble(cursor.getString(1)));
            model.setCota_atencao(Double.parseDouble(cursor.getString(2)));
            model.setCota_alerta(Double.parseDouble(cursor.getString(3)));
            model.setCota_inundacao(Double.parseDouble(cursor.getString(4)));
        }
        return model;
    }

    public long atualizar(CotasModel model) {
        ContentValues values = new ContentValues();
        values.put("id", model.getId());
        values.put("cota_normal", model.getCota_normal());
        values.put("cota_atencao", model.getCota_atencao());
        values.put("cota_alerta", model.getCota_alerta());
        values.put("cota_inudacao", model.getCota_inundacao());

        // Retorna o id do registro atualizado
        return banco.update("cotas", values, "id = ?", new String[]{String.valueOf(model.getId())});
    }

    public int excluir(CotasModel model) {
        return banco.delete("cotas", "id = ?", new String[]{String.valueOf(model.getId())});
    }
}
