package com.example.appflood;

public class BairroModel {
    private String cota;
    private String nome;
    private String atingidos;

    public String getCota() { return cota;}

    public void setCota(String cota) { this.cota = cota; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getAtingidos() { return atingidos; }

    public void setAtingidos(String atingidos) { this.atingidos = atingidos; }

    @Override
    public String toString() {
        return "nome: " + nome + "cota: " + cota + "atingidos: " + atingidos;
    }


}
