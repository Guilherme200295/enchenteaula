package com.example.appflood;

public class CotasModel {
    private int id;
    private Double cota_normal;
    private Double cota_atencao;
    private Double cota_alerta;
    private Double cota_inundacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getCota_normal() {
        return cota_normal;
    }

    public void setCota_normal(Double cota_normal) {
        this.cota_normal = cota_normal;
    }

    public Double getCota_atencao() {
        return cota_atencao;
    }

    public void setCota_atencao(Double cota_atencao) {
        this.cota_atencao = cota_atencao;
    }

    public Double getCota_alerta() {
        return cota_alerta;
    }

    public void setCota_alerta(Double cota_alerta) {
        this.cota_alerta = cota_alerta;
    }

    public Double getCota_inundacao() {
        return cota_inundacao;
    }

    public void setCota_inundacao(Double cota_inundacao) {
        this.cota_inundacao = cota_inundacao;
    }
}



