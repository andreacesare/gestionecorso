package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Corso {
    private String nome;
    private LocalDate data_inizio;
    private String durata;
    private Docente docente;
    private int id;
    private ArrayList<Discente> discenti=new ArrayList<>();

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {this.nome = nome;}
    public LocalDate getData_inizio() {
        return this.data_inizio;
    }
    public void setData_inizio(LocalDate data_inizio) {this.data_inizio = data_inizio;}
    public String getDurata() {return this.durata;}
    public void setDurata(String durata) {this.durata = durata;}
    public int getId() {return this.id;}
    public void setId(int id) {this.id = id;}
    public Docente getDocente() {return this.docente;}
    public void setDocente(Docente docente) {this.docente = docente;}
    public void aggiungiDiscente(Discente discente) {discenti.add(discente);}


}
