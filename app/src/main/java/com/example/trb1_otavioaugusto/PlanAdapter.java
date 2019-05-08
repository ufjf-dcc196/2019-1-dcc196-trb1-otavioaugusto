package com.example.trb1_otavioaugusto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.ViewHolder> {
    private List<Planejamento> itens;
    private OnItemClickListener listener;

    public PlanAdapter(List<Planejamento> itens) {
        this.itens = itens;
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

        View itemView = inflater.inflate(R.layout.item_plan, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder Holder, int position) {
        Planejamento planejamento = itens.get(position);

        TextView itemAno = Holder.itemAno;
        TextView itemSemestre = Holder.itemSemestre;
        TextView itemExatas = Holder.itemExatas;
        TextView itemHumanas = Holder.itemHumanas;
        TextView itemLinguas = Holder.itemLinguas;
        TextView itemSaude = Holder.itemSaude;
        TextView itemExatasPer = Holder.itemExatasPer;
        TextView itemHumanasPer = Holder.itemHumanasPer;
        TextView itemLinguasPer = Holder.itemLinguasPer;
        TextView itemSaudePer = Holder.itemSaudePer;

        int totalHoras, totalExatas, totalHumanas, totalSaude, totalLinguas;
        float exatasPer, humanasPer, linguasPer, saudePer;

        totalExatas = planejamento.getTotalExatas();
        totalHumanas = planejamento.getTotalHumanas();
        totalSaude = planejamento.getTotalSaude();
        totalLinguas = planejamento.getTotalLinguas();
        totalHoras = totalExatas + totalHumanas + totalSaude + totalLinguas;

        if (totalHoras == 0) {
            exatasPer = 0;
            humanasPer = 0;
            linguasPer = 0;
            saudePer = 0;
        } else {
            exatasPer = ((float) totalExatas / totalHoras) * 100;
            humanasPer = ((float) totalHumanas / totalHoras) * 100;
            linguasPer = ((float) totalLinguas / totalHoras) * 100;
            saudePer = ((float) totalSaude / totalHoras) * 100;
        }

//        exatasPer = totalExatas;
//        humanasPer = totalHumanas;
//        linguasPer = totalLinguas;
//        saudePer = totalSaude;


        itemAno.setText(String.valueOf(planejamento.getAno()));
        itemSemestre.setText(String.valueOf(planejamento.getSemestre()));
        itemExatas.setText(String.valueOf(planejamento.getExatas()) + "%");
        itemHumanas.setText(String.valueOf(planejamento.getHumanidades()) + "%");
        itemLinguas.setText(String.valueOf(planejamento.getLinguas()) + "%");
        itemSaude.setText(String.valueOf(planejamento.getSaude()) + "%");

        itemExatasPer.setText(String.valueOf(exatasPer) + "%");
        itemHumanasPer.setText(String.valueOf(humanasPer) + "%");
        itemLinguasPer.setText(String.valueOf(linguasPer) + "%");
        itemSaudePer.setText(String.valueOf(saudePer) + "%");
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView itemAno;
        public TextView itemSemestre;
        public TextView itemExatas;
        public TextView itemHumanas;
        public TextView itemLinguas;
        public TextView itemSaude;
        public TextView itemExatasPer;
        public TextView itemHumanasPer;
        public TextView itemLinguasPer;
        public TextView itemSaudePer;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            itemAno = itemView.findViewById(R.id.textPlanAno);
            itemSemestre = itemView.findViewById(R.id.textPlanSemestre);
            itemExatas = itemView.findViewById(R.id.textPlanExatas);
            itemHumanas = itemView.findViewById(R.id.textPlanHumanas);
            itemLinguas = itemView.findViewById(R.id.textPlanLinguas);
            itemSaude = itemView.findViewById(R.id.textPlanSaude);

            itemExatasPer = itemView.findViewById(R.id.textPlanExatas2);
            itemHumanasPer = itemView.findViewById(R.id.textPlanHumanas2);
            itemLinguasPer = itemView.findViewById(R.id.textPlanLinguas2);
            itemSaudePer = itemView.findViewById(R.id.textPlanSaude2);

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

