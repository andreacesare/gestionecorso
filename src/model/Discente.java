package model;

import java.util.ArrayList;
import java.util.Date;

public class Discente {
    private String nome;
    private String cognome;
    private String matricola;
    private String data_nascita;

    private int id;
    private ArrayList<Corso> corsi=new ArrayList();

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

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getMatricola() {
        return matricola;
    }
    public void setData_nascita(String data_nascita) {this.data_nascita = data_nascita;}

    public String getData_nascita() {
        return data_nascita;
    }
    public void aggiungiCorso(Corso corso) {
        corsi.add(corso);
    }
}
