package com.example.appflood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CabeceirasDoRioDAO {
        private Conexao conexao;
        private SQLiteDatabase banco;

        public CabeceirasDoRioDAO(Context context) {
            conexao = new Conexao(context);
            banco = conexao.getWritableDatabase();
        }

        public long inserir(CabeceirasDoRioModel model) {
            ContentValues values = new ContentValues();
            values.put("id", model.getId());
            values.put("nivel", model.getNivel());
            values.put("cidade", model.getCidade());
            values.put("hora_medicao", model.getHora_medicao());
            values.put("id_cota", model.getId_cota());

            // Retorna o id do registro inserido
            return banco.insert("cabeceiras_do_rio", null, values);
        }

        public ArrayList<CabeceirasDoRioModel> listar() {
            ArrayList<CabeceirasDoRioModel> lista = new ArrayList<>();
            Cursor cursor = banco.query("cabeceiras_do_rio", new String[]{"id", "nivel", "cidade", "hora_medicao", "id_cota"}, null, null, null, null, null);
            while (cursor.moveToNext()) {
                CabeceirasDoRioModel model = new CabeceirasDoRioModel();
                model.setId(cursor.getInt(0));
                model.setNivel(Double.parseDouble(cursor.getString(1)));
                model.setCidade(cursor.getString(2));
                model.setHora_medicao(Double.parseDouble(cursor.getString(3)));
                model.setId_cota(cursor.getInt(4));
                lista.add(model);
            }

            return lista;
        }

        public CabeceirasDoRioModel ler(int id) {
            CabeceirasDoRioModel model = new CabeceirasDoRioModel();
            Cursor cursor = banco.query("cabeceiras_do_rio", new String[]{"id", "nivel", "cidade","hora_medicao", "id_cota"}, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
            while (cursor.moveToNext()) {
                model.setId(cursor.getInt(0));
                model.setNivel(Double.parseDouble(cursor.getString(1)));
                model.setCidade(cursor.getString(2));
                model.setHora_medicao(Double.parseDouble(cursor.getString(3)));
                model.setId_cota(cursor.getInt(4));
            }
            return model;
        }

        public long atualizar(CabeceirasDoRioModel model) {
            ContentValues values = new ContentValues();
            values.put("id", model.getId());
            values.put("nivel", model.getNivel());
            values.put("cidade", model.getCidade());
            values.put("hora_medicao", model.getHora_medicao());
            values.put("id_cota", model.getId_cota());

            // Retorna o id do registro atualizado
            return banco.update("cabeceiras_do_rio", values, "id = ?", new String[]{String.valueOf(model.getId())});
        }

        public int excluir(CabeceirasDoRioModel model) {
            return banco.delete("cabeceiras_do_rio", "id = ?", new String[]{String.valueOf(model.getId())});
        }
}
