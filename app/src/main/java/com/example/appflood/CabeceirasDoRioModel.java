package com.example.appflood;

public class CabeceirasDoRioModel {
    private String nivel;
    private String cidade;
    private String hora_medicao;

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getHora_medicao() {
        return hora_medicao;
    }

    public void setHora_medicao(String hora_medicao) {
        this.hora_medicao = hora_medicao;
    }

    @Override
    public String toString() {
        return "Nível: " + nivel + "\n" + "Cidade: " + cidade + "\n"  + "Hora da medição: " + hora_medicao;
    }
}





