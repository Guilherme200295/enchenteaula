package com.example.appflood;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HTTPCabeceirasDoRio  extends AsyncTask<Void, Void, List<CabeceirasDoRioModel>> {


    @Override
    protected List<CabeceirasDoRioModel> doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();

        try {
            URL url = new URL("https://meu-web-service-74yj3bcbk-guilherme200295.vercel.app/cabeceiras.json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                resposta.append(scanner.next());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Type listType = new TypeToken<ArrayList<CabeceirasDoRioModel>>(){}.getType();
        List<CabeceirasDoRioModel> lista = new Gson().fromJson(resposta.toString(), listType);

        return lista;


    }
}
