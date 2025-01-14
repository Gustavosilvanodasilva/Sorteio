package com.cursoandroid.sorteio;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class SecundariaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        Button sortearButton = findViewById(R.id.button);
        EditText numeroMaximo = findViewById(R.id.text_digito);

        // Encontra o botão e associa o evento de clique ao método sortear
        sortearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pega o valor inserido pelo usuário
                String Numeromaximo = numeroMaximo.getText().toString();

                // Verifica se o campo não está vazio
                if (!Numeromaximo.isEmpty()) {
                    int digito = Integer.parseInt(Numeromaximo);

                    // Verifica se o número máximo é maior que zero
                    if (digito > 0) {
                        // Chama o método sortear com o número máximo inserido pelo usuário
                        sortear(digito);
                    } else {
                        Toast.makeText(SecundariaActivity.this, "Por favor, insira um número maior que zero.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Mostra uma mensagem de erro se o campo estiver vazio
                    Toast.makeText(SecundariaActivity.this, "Por favor, insira um número máximo.", Toast.LENGTH_SHORT).show();
                }
                // Esconder o teclado
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if(imm !=null){
                    imm.hideSoftInputFromWindow(numeroMaximo.getWindowToken(), 0);
                }
            }
        });


    }

    protected void sortear(int escolhaNumeros) {
        TextView textResultado = findViewById(R.id.text_resultado);
        Random random = new Random();

        // Verifica se o valor de escolhaNumeros é maior que 0
        if (escolhaNumeros > 0) {
            // Sorteia um número entre 1 e o valor máximo inserido pelo usuário
            int numero = random.nextInt(escolhaNumeros) + 1;  // Adiciona 1 para garantir que o número mínimo seja 1

            // Exibe o número sorteado
            textResultado.setText("Número Sorteado: " + numero);
        } else {
            // Exibe uma mensagem de erro se escolhaNumeros não for maior que 0
            textResultado.setText("Número máximo deve ser maior que 0.");
        }

    }

}
