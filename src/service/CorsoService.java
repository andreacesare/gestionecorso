package service;

import model.Corso;
import model.Docente;
import repository.CorsoRepository;

import java.time.LocalDate;
import java.util.List;


public class CorsoService {
    CorsoRepository CorsoRepository = new CorsoRepository();



    public void create(String nome, LocalDate data_inizio,String durata,Docente docente) {
        Corso oCorso = new Corso();
        oCorso.setNome(nome);
        oCorso.setData_inizio(data_inizio);
        oCorso.setDurata(durata);
        oCorso.setDocente(docente);
        CorsoRepository.createCorso(oCorso);

    }
    public List<Corso> readCorso(){return CorsoRepository.readCorso();}

    public void delete(int id) {
        Corso corso=new Corso();
        corso.setId(id);
        CorsoRepository.deleteCorso(corso);
    }
    public void update(int id, String nome, LocalDate data_inizio, String durata, Docente docente) {
        Corso corso=new Corso();
        corso.setId(id);
        corso.setNome(nome);
        corso.setData_inizio(data_inizio);
        corso.setDurata(durata);
        corso.setDocente(docente);
    }



}
