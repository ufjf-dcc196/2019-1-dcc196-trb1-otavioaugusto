package com.example.trb1_otavioaugusto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetalhesPlanejamentoActivity extends AppCompatActivity {
    Planejamento planejamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_planejamento);

        final EditText ano = findViewById(R.id.editText_Ano2);
        final EditText semestre = findViewById(R.id.editText_Semestre2);
        final EditText exatas = findViewById(R.id.editText_Exatas2);
        final EditText humanidades = findViewById(R.id.editText_Humanas2);
        final EditText linguas = findViewById(R.id.editText_Linguas2);
        final EditText saude = findViewById(R.id.editText_Saude2);
        Button btnConfirmar = findViewById(R.id.button_add_plan2);


        Intent bundleExtras = getIntent();
        planejamento = (Planejamento) bundleExtras.getSerializableExtra("planejamento");

        ano.setText(String.valueOf(planejamento.getAno()));
        semestre.setText(String.valueOf(planejamento.getSemestre()));
        linguas.setText(String.valueOf(planejamento.getLinguas()));
        exatas.setText(String.valueOf(planejamento.getExatas()));
        saude.setText(String.valueOf(planejamento.getSaude()));
        humanidades.setText(String.valueOf(planejamento.getHumanidades()));

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Float.parseFloat(exatas.getText().toString()) + Float.parseFloat(humanidades.getText().toString()) + Float.parseFloat(saude.getText().toString()) + Float.parseFloat(linguas.getText().toString()) != 100) {
                    Toast.makeText(DetalhesPlanejamentoActivity.this, "A soma das áreas deve completar 100%", Toast.LENGTH_LONG).show();
                } else {

                    Intent resultado = new Intent();

                    planejamento.setAno(Integer.parseInt(ano.getText().toString()));
                    planejamento.setSemestre(Integer.parseInt(semestre.getText().toString()));
                    planejamento.setLinguas(Float.parseFloat(linguas.getText().toString()));
                    planejamento.setExatas(Float.parseFloat(exatas.getText().toString()));
                    planejamento.setSaude(Float.parseFloat(saude.getText().toString()));
                    planejamento.setHumanidades(Float.parseFloat(humanidades.getText().toString()));

                    resultado.putExtra("lastPlan", planejamento);
                    setResult(RESULT_OK, resultado);
                    finish();
                }
            }
        });

    }
}
