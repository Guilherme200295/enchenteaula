package com.example.appflood;

public class CotasModel {
    private String cota_normal;
    private String cota_atencao;
    private String cota_alerta;
    private String cota_inundacao;

    public String getCota_normal() {
        return cota_normal;
    }

    public void setCota_normal(String cota_normal) {
        this.cota_normal = cota_normal;
    }

    public String getCota_atencao() {
        return cota_atencao;
    }

    public void setCota_atencao(String cota_atencao) {
        this.cota_atencao = cota_atencao;
    }

    public String getCota_alerta() {
        return cota_alerta;
    }

    public void setCota_alerta(String cota_alerta) {
        this.cota_alerta = cota_alerta;
    }

    public String getCota_inundacao() {
        return cota_inundacao;
    }

    public void setCota_inundacao(String cota_inundacao) {
        this.cota_inundacao = cota_inundacao;
    }
    @Override
    public String toString() {
        return "Cota normal: " + cota_normal + "\n" + "Cota de atencao: " + cota_atencao + "\n"  + "Cota de alerta: " + cota_alerta + "\n" + "Cota de inundacao" + cota_inundacao;
    }
}



