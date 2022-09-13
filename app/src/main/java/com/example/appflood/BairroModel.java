package com.example.appflood;

public class BairroModel {
    private int id;
    private String nome;
    private Double atingidos;
    private int id_cota;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getAtingidos() {
        return atingidos;
    }

    public void setAtingidos(Double atingidos) {
        this.atingidos = atingidos;
    }

    public int getId_cota() {
        return id_cota;
    }

    public void setId_cota(int id_cota) {
        this.id_cota = id_cota;
    }
}
