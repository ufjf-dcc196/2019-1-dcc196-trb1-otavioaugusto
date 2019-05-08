package com.example.trb1_otavioaugusto;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlanejamentosActivity extends AppCompatActivity {

    public List<Planejamento> itens = new ArrayList<Planejamento>() {{
        add(new Planejamento(2019, 1, 25, 25, 25, 25));
        add(new Planejamento(2018, 1, 25, 25, 25, 25));
        add(new Planejamento(2017, 1, 25, 25, 25, 25));
    }};

    Disciplina disciplina = new Disciplina("Calculo 1", 60, "Exatas");
    PlanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Planejamento plane = itens.get(0);
        plane.addDisciplina(disciplina);


        RecyclerView rv = findViewById(R.id.recyclerView_plans);

        adapter = new PlanAdapter(this.itens);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnItemClickListener(new PlanAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Intent intent = new Intent(PlanejamentosActivity.this, DisciplinasCursadasActivity.class);
                intent.putExtra("planejamento", itens.get(position));
                intent.putExtra("posicao", position);
                startActivityForResult(intent,2);
            }

        });

        Button buttonNovoPlan = findViewById(R.id.button_novo_plan);
        buttonNovoPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanejamentosActivity.this, NovoPlanejamentoActivity.class);
                startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data != null) switch (requestCode) {
            case 1:
                if (resultCode == Activity.RESULT_OK) {
//                        TextView teste = findViewById(R.id.teste);
//                        teste.setText("ok");
                    Planejamento plan = (Planejamento )data.getSerializableExtra("novoPlanejamento");
                    itens.add(plan);
                    adapter.notifyDataSetChanged();
                }
                break;
            case 2:
                int pos = data.getIntExtra("posicao", 0 );
                itens.set(pos, (Planejamento) data.getSerializableExtra("planAtual"));
                adapter.notifyDataSetChanged();
                break;
            default:
                break;
        }
    }
}
