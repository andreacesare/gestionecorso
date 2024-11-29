package model;

import java.util.ArrayList;

public class Docente {

    private String nome;
    private String cognome;
    private int id;
    private ArrayList<Corso> corsi;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getid() {
        return id;
    }
    public ArrayList<Corso> getCorsi() { return corsi;}
    public void addCorso(Corso corso) {
        corsi.add(corso);
    }


}
