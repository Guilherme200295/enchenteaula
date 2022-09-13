package com.example.appflood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private Button btn_entrar;
    private TextView usuario;
    private TextView senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

            btn_entrar = (Button) findViewById(R.id.btn_entrar);
            btn_entrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    usuario = (TextView) findViewById(R.id.usuario);
                    senha = (TextView) findViewById(R.id.senha);

                    if (usuario.getText().toString().equals("teste") && senha.getText().toString().equals("12345")) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        System.out.println("Usuário ou senha inválidos!");
                    }
                }
            });
        }
    }