package com.example.appflood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Bairro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bairro);


        try {
            List<BairroModel> bairros = new HTTPBairro().execute().get();

           Spinner spinner = findViewById(R.id.spinner);
            ArrayAdapter<BairroModel> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, bairros);
            spinner.setAdapter(adapter);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}