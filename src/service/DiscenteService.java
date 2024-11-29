package service;

import model.Corso;
import model.Discente;
import repository.DiscenteRepository;


import java.util.List;

public class DiscenteService {
    DiscenteRepository discenteRepository = new DiscenteRepository();



    public void create(String nome, String cognome, String matricola, String data_nascita, Corso corso) {
        Discente oDiscente = new Discente();
        oDiscente.setNome(nome);
        oDiscente.setCognome(cognome);
        oDiscente.setMatricola(matricola);
        oDiscente.setData_nascita(data_nascita);
        oDiscente.aggiungiCorso(corso);
        corso.aggiungiDiscente(oDiscente);
        discenteRepository.createDiscente(oDiscente);
    }


    public List<Discente> readDiscente(){
        return discenteRepository.readDiscente();
    }


    public void delete(int id) {
        Discente oDiscente = new Discente();
        oDiscente.setid(id);
        discenteRepository.deleteDiscente(oDiscente);
    }

    public void update(int id, String nome, String cognome,String matricola,String data_nascita) {
        Discente oDiscente = new Discente();
        oDiscente.setid(id);
        oDiscente.setNome(nome);
        oDiscente.setCognome(cognome);
        oDiscente.setMatricola(matricola);
        oDiscente.setData_nascita(data_nascita);
        discenteRepository.updateDiscente(oDiscente);

    }

}
