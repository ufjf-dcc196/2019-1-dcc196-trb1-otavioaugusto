package com.example.trb1_otavioaugusto;

import java.io.Serializable;

public class Disciplina implements Serializable {
    protected String nome;
    protected int horas;
    protected String area;

    public Disciplina (String nome, int horas, String area) {
        this.nome = nome;
        this.horas = horas;
        this.area = area;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
