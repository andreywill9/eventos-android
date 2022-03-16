package com.example.calculos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtResultado;

    private EditText edtValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        txtResultado = findViewById(R.id.txtResultado);
        edtValor = findViewById(R.id.edtValor);
        Button btnQuadrado = findViewById(R.id.btnQuadrado);
        Button btnCubo = findViewById(R.id.btnCubo);
        Button btnRaiz = findViewById(R.id.btnRaiz);
        Button btnLimpar = findViewById(R.id.btnLimpar);
        btnQuadrado.setOnClickListener(view -> acaoBotao(this::calcularQuadrado));
        btnCubo.setOnClickListener(view -> acaoBotao(this::calcularCubo));
        btnRaiz.setOnClickListener(view -> acaoBotao(this::calculcarRaiz));
        btnLimpar.setOnClickListener(view -> {
            txtResultado.setText("");
            txtResultado.requestFocus();
        });
    }

    private void acaoBotao(Runnable acao) {
        try {
            validarValorDigitado();
            acao.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validarValorDigitado() {
        if (edtValor.getText().toString().isEmpty()) {
            Toast.makeText(this, "Digite um valor", Toast.LENGTH_LONG).show();
            edtValor.requestFocus();
            throw new IllegalArgumentException();
        }
    }

    private void calcularQuadrado() {
        Float valor = Float.parseFloat(edtValor.getText().toString());
        txtResultado.setText(String.valueOf(valor * valor));
    }

    private void calcularCubo() {
        Float valor = Float.parseFloat(edtValor.getText().toString());
        txtResultado.setText(String.valueOf(valor * valor * valor));
    }

    private void calculcarRaiz() {
        double valor = Double.parseDouble(edtValor.getText().toString());
        if (valor < 0) {
            Toast.makeText(this, "Número não pode ser negativo", Toast.LENGTH_LONG).show();
            txtResultado.setText("");
            throw new IllegalArgumentException();
        }
        txtResultado.setText(String.valueOf(Math.sqrt(valor)));
    }
}