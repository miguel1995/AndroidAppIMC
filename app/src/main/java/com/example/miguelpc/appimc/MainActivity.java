
//Fuente:  https://www.youtube.com/watch?v=uibhUlXkD6s&index=40&list=PLRRyJTxdPZVe3I-bECCnKoufiUkJrajNQ
package com.example.miguelpc.appimc;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText textTalla, textPeso;
    Button botonCalcular;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTalla = (EditText) findViewById(R.id.etTalla);
        textPeso = (EditText) findViewById(R.id.etPeso);
        botonCalcular = (Button) findViewById(R.id.btnCalcular);
        resultado = (TextView) findViewById(R.id.tvResultado);

        botonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double talla = Double.parseDouble(textTalla.getText().toString());
                double peso = Double.parseDouble(textPeso.getText().toString());
                double resultadoIMC = peso / (talla * talla);
                resultado.setText("Su indice de masa corporal es: " + resultadoIMC);

                if (resultadoIMC < 18.5){
                    Toast.makeText(getApplicationContext(), "Su peso es menor del normal", Toast.LENGTH_LONG).show();
                }else if(resultadoIMC >= 18.5 && resultadoIMC < 24.9){
                    Toast.makeText(getApplicationContext(), "Su peso es normal", Toast.LENGTH_LONG).show();
                }else if (resultadoIMC >= 24.9 && resultadoIMC < 29.9){
                    Toast.makeText(getApplicationContext(), "Su peso es superior del normal", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Obesidad", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
