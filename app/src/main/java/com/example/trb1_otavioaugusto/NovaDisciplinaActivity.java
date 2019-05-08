package com.example.trb1_otavioaugusto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class NovaDisciplinaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_disciplina);

        final EditText nome = findViewById(R.id.editText_nome_disciplina);
        final EditText horas = findViewById(R.id.editText_num_horas);
        final EditText area = findViewById(R.id.editText_area);
        Button btnConfirmar = findViewById(R.id.button_nova_disciplina);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultado = new Intent();
                Disciplina d = new Disciplina(
                        nome.getText().toString(),
                        Integer.parseInt(horas.getText().toString()),
                        area.getText().toString()
                );

                resultado.putExtra("novaDisciplina", d);
                setResult(RESULT_OK, resultado);
                finish();
            }
        });
    }
}
