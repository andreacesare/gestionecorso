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

}