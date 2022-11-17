package com.example.appflood;

import android.os.AsyncTask;

import java.net.URL;

public class HTTPBairro extends AsyncTask <Void,Void, BairroModel> {

    private final String Bairro;

    public HTTPBairro(String bairro) {
        Bairro = bairro;
    }


    @Override
    protected BairroModel doInBackground(Void... voids) {
        return null;
    }
}
