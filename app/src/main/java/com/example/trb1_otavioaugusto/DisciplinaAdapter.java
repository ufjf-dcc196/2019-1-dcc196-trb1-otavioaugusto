package com.example.trb1_otavioaugusto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class DisciplinaAdapter extends RecyclerView.Adapter<DisciplinaAdapter.ViewHolder> {
    {
    }

    private List<Disciplina> itens;
    private OnItemClickListener listener;

    public DisciplinaAdapter(List<Disciplina> items) {
        this.itens = items;
    }

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.item_disciplina, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DisciplinaAdapter.ViewHolder viewHolder, int i) {
        Disciplina d = itens.get(i);
        TextView itemNome = viewHolder.itemNome;
        TextView itemHoras = viewHolder.itemHoras;
        TextView itemArea = viewHolder.itemArea;


        itemNome.setText(String.valueOf(d.getNome()));
        itemHoras.setText(String.valueOf(d.getHoras()));
        itemArea.setText(String.valueOf(d.getArea()));
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView itemNome, itemHoras, itemArea;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            itemNome = itemView.findViewById(R.id.textNomeDisciplina);
            itemHoras = itemView.findViewById(R.id.textHorasDisciplina);
            itemArea = itemView.findViewById(R.id.textAreaDisciplina);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                        }
                    }
                }
            });

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(v, position);
            }
        }

    }
}
