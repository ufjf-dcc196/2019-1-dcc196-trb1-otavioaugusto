package com.example.trb1_otavioaugusto;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class DisciplinasCursadasActivity extends AppCompatActivity {
    public static final int REQUEST_DISCIPLINA = 1;
    Planejamento planejamento;
    DisciplinaAdapter adapter;
    int posicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas_cursadas);

        Intent bundleExtras = getIntent();
        planejamento = (Planejamento) bundleExtras.getSerializableExtra("planejamento");
        posicao = (int) bundleExtras.getSerializableExtra("posicao");

        RecyclerView rv = findViewById(R.id.recyclerView_diciplinas);
        Button btnNovaDisciplina = findViewById(R.id.button_nova_diciplina);
        btnNovaDisciplina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisciplinasCursadasActivity.this, NovaDisciplinaActivity.class);
                startActivityForResult(intent, REQUEST_DISCIPLINA);
            }
        });
        Button btnDetalhesPlanejamento = findViewById(R.id.button_detalhes_plan);
        btnDetalhesPlanejamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisciplinasCursadasActivity.this, DetalhesPlanejamentoActivity.class);
                intent.putExtra("planejamento", planejamento);
                startActivityForResult(intent, 2);
            }
        });


        adapter = new DisciplinaAdapter(planejamento.getDisciplinas());

        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Intent resultado = new Intent();
        resultado.putExtra("posicao", posicao);
        ;
        if (resultCode == Activity.RESULT_OK && data != null) {
            switch (requestCode) {
                case REQUEST_DISCIPLINA:
                    planejamento.addDisciplina((Disciplina) data.getSerializableExtra("novaDisciplina"));
                    resultado.putExtra("planAtual", planejamento);
                    setResult(RESULT_CANCELED, resultado);
                    adapter.notifyDataSetChanged();
                    break;
                case 2:
                    planejamento = (Planejamento) data.getSerializableExtra("lastPlan");
                    resultado.putExtra("planAtual", planejamento);
                    setResult(RESULT_CANCELED, resultado);
                    adapter.notifyDataSetChanged();
                default:
                    break;
            }
        }
    }
}
