package com.example.trb1_otavioaugusto;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Planejamento implements Serializable {
    protected int ano, semestre;
    protected float linguas, exatas, saude, humanidades;
    protected List<Disciplina> disciplinas;


    public Planejamento(int ano, int semestre, float linguas, float exatas, float saude, float humanidades) {
        this.ano = ano;
        this.semestre = semestre;
        this.linguas = linguas;
        this.exatas = exatas;
        this.saude = saude;
        this.humanidades = humanidades;
        this.disciplinas = new ArrayList<Disciplina>();
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public float getLinguas() {
        return linguas;
    }

    public void setLinguas(float linguas) {
        this.linguas = linguas;
    }

    public float getExatas() {
        return exatas;
    }

    public void setExatas(float exatas) {
        this.exatas = exatas;
    }

    public float getSaude() {
        return saude;
    }

    public void setSaude(float saude) {
        this.saude = saude;
    }

    public float getHumanidades() {
        return humanidades;
    }

    public void setHumanidades(float humanidades) {
        this.humanidades = humanidades;
    }

    public Disciplina getDisciplina(int i) {
        return this.disciplinas.get(i);
    }
    public List<Disciplina> getDisciplinas(){
        return this.disciplinas;
    }
    public void addDisciplina(Disciplina d) {
        if (this.disciplinas == null) {
            this.disciplinas = new ArrayList<Disciplina>();
        }
        this.disciplinas.add(d);
    }

    public int getTotalExatas(){
        int horas = 0;
            for (Disciplina d : this.disciplinas)
                if (d.getArea().toUpperCase().equals("EXATAS")) {
                    horas += d.getHoras();
                }
        return horas;
    }
    public int getTotalHumanas(){
        int horas = 0;
            for (Disciplina d : this.disciplinas)
                if (d.getArea().toUpperCase().equals("HUMANAS")) {
                    horas += d.getHoras();
                }
        return horas;
    }
    public int getTotalLinguas(){
        int horas = 0;
            for (Disciplina d : this.disciplinas)
                if (d.getArea().toUpperCase().equals("LINGUAS")) {
                    horas += d.getHoras();
                }
        return horas;
    }
    public int getTotalSaude(){
        int horas = 0;
            for (Disciplina d : this.disciplinas)
                if (d.getArea().toUpperCase().equals("SAUDE")) {
                    horas += d.getHoras();
                }
        return horas;
    }

    

}
