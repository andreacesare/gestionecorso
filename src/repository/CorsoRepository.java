package repository;
import config.DbConnection;
import model.Corso;
import model.Docente;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
public class CorsoRepository {
    public void createCorso(Corso oCorso) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO CorsoTest VALUES('" + oCorso.getNome() + "','" + oCorso.getData_inizio() + "','" + oCorso.getDurata() + "','" + oCorso.getDocente().getid() + "')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
        public ArrayList<Corso> readCorso () {
            ArrayList<Corso> listaCorsi = new ArrayList<>();
            try {
                Connection c = DbConnection.openConnection();
                System.out.println("Connessione riuscita!");
                Statement stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT c.nome as nome_corso,c.data_inizio,c.durata,c.id as id_corso,d.nome as nome_docente,d.cognome,c.id_docente FROM CorsoTest c JOIN DocenteTest d on c.id_docente=d.id  ORDER BY c.id asc");
                while (rs.next()) {
                    Corso corso = new Corso();
                    corso.setNome(rs.getString("nome_corso"));
                    Date dataInizio = rs.getDate("data_inizio"); // Usa getDate per ottenere una java.sql.Date
                    if (dataInizio != null) {
                        corso.setData_inizio(dataInizio.toLocalDate()); // Converte java.sql.Date in LocalDate
                    }


                    corso.setDurata(rs.getString("durata"));
                    corso.setId(rs.getInt("id_corso"));
                    Docente docente = new Docente();
                    docente.setid(rs.getInt("id_docente"));
                    docente.setNome(rs.getString("nome_docente"));
                    docente.setCognome(rs.getString("cognome"));
                    corso.setDocente(docente);

                    listaCorsi.add(corso);


                }
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println(e.getMessage());
                System.exit(0);
            }
            return listaCorsi;

        }
    public void deleteCorso(Corso oCorso) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM CorsoTest WHERE id = '" + oCorso.getId() + "'");
            System.out.println("model.dao.Corso eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

    }
    public void updateCorso(Corso corso) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE DocenteTest SET nome='"+corso.getNome()+"', data_inizio='"+corso.getData_inizio()+"',durata='"+corso.getDurata()+"',id_docente='"+corso.getDocente().getid()+"'  WHERE id ="  + corso.getId());
            System.out.println("model.dao.Docente aggiornato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    }

