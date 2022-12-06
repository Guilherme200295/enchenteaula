package com.example.appflood;

public class RioTaquariModel {
    private String nivel;
    private String hora_medicao;
    private String id_cota;

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getHora_medicao() {
        return hora_medicao;
    }

    public void setHora_medicao(String hora_medicao) {
        this.hora_medicao = hora_medicao;
    }

    public String getId_cota() {
        return id_cota;
    }

    public void setId_cota(String id_cota) {
        this.id_cota = id_cota;
    }

    @Override
    public String toString() {
        return "Nivel: " + nivel + "\n" + "Hora da medicao: " + hora_medicao + "\n"  + "Cota atual: " + id_cota;
    }
}







