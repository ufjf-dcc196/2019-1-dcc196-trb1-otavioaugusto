package com.example.trb1_otavioaugusto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NovoPlanejamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_planejamento);

        final EditText ano = findViewById(R.id.editText_Ano);
        final EditText semestre = findViewById(R.id.editText_Semestre);
        final EditText exatas = findViewById(R.id.editText_Exatas);
        final EditText humanidades = findViewById(R.id.editText_Humanas);
        final EditText linguas = findViewById(R.id.editText_Linguas);
        final EditText saude = findViewById(R.id.editText_Saude);
        Button btnConfirmar = findViewById(R.id.button_add_plan);


        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int novo_ano, novo_semestre;
                float novo_linguas, novo_exatas, novo_saude, novo_humanidades;

                novo_ano = Integer.parseInt(ano.getText().toString());
                novo_semestre = Integer.parseInt(semestre.getText().toString());
                novo_linguas = Float.parseFloat(linguas.getText().toString());
                novo_exatas = Float.parseFloat(exatas.getText().toString());
                novo_saude = Float.parseFloat(saude.getText().toString());
                novo_humanidades = Float.parseFloat(humanidades.getText().toString());

                if (novo_linguas + novo_exatas + novo_saude + novo_humanidades != 100) {
                    Toast.makeText(NovoPlanejamentoActivity.this, "A soma das áreas deve completar 100%", Toast.LENGTH_LONG).show();
                } else {
                    Intent resultado = new Intent();
                    Planejamento plan = new Planejamento(novo_ano,novo_semestre,novo_linguas,novo_exatas,novo_saude,novo_humanidades);
                    resultado.putExtra("novoPlanejamento", plan);
                    setResult(RESULT_OK, resultado);
                    finish();
                }
            }
        });
    }
}
