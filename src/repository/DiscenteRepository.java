package repository;

import config.DbConnection;
import model.Discente;

import java.sql.*;
import java.util.ArrayList;

public class DiscenteRepository {
    public void createDiscente(Discente oDiscente) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO DiscenteTest VALUES('" + oDiscente.getNome() + "','" + oDiscente.getCognome() + "','" + oDiscente.getMatricola() + "','"+oDiscente.getData_nascita()+"')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }


    public ArrayList<Discente> readDiscente() {
        ArrayList<Discente> listaDiscenti = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM DiscenteTest ORDER BY id asc");
            while (rs.next()) {
                Discente oDiscente = new Discente();
                oDiscente.setNome(rs.getString("nome"));
                oDiscente.setCognome(rs.getString("cognome"));
                oDiscente.setMatricola(rs.getString("matricola"));
                oDiscente.setData_nascita(rs.getString("data_nascita"));
                oDiscente.setid(rs.getInt("id"));
                listaDiscenti.add(oDiscente);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaDiscenti;
    }

    public void deleteDiscente(Discente oDiscente) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM DiscenteTest WHERE id = '" + oDiscente.getid() + "'");
            System.out.println("model.dao.Discente eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void updateDiscente(Discente oDiscente) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE DiscenteTest SET nome='" + oDiscente.getNome() + "', cognome='" + oDiscente.getCognome() + "',matricola='" + oDiscente.getMatricola() + "',data_nascita='"+oDiscente.getData_nascita()+"' WHERE id =" + oDiscente.getid());
            System.out.println("model.dao.Discente aggiornato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
