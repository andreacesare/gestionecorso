package service;

import model.Corso;
import model.Docente;
import repository.CorsoRepository;

import java.time.LocalDate;


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

}
