package view;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import model.Corso;
import model.Discente;
import model.Docente;
import service.CorsoService;
import service.DiscenteService;
import service.DocenteService;

import java.util.*;




public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice1;
        int choice2;


        do {
            System.out.println("1.Docente \n 2.Discente \n 3.Corso \n 4.exit");
            System.out.print("inserisci la tua scelta: ");
            choice1 = scanner.nextInt();
            if (choice1 == 1) {
                System.out.println("Classe docente");


                System.out.println("***Menu***");
                System.out.println("1. Crea un nuovo docente");
                System.out.println("2. Aggiorna un docente");
                System.out.println("3. Visualizza la lista di docenti");
                System.out.println("4. Elimina un docente");
                System.out.println("9. Exit");
                System.out.print("inserisci la tua scelta: ");

                // Read user input
                choice2 = scanner.nextInt();
                switch (choice2) {
                    case 1:
                        createDoc();
                        break;
                    case 2:
                        updateDoc();
                        break;
                    case 3:
                        readDoc();
                        break;
                    case 4:
                        deleteDoc();
                        break;
                    case 9:
                        System.out.println("exiting");
                        break;
                    default:
                        System.out.println("scelta errata. scegliere un numero da 1 a 8");
                }

            } else if (choice1 == 2) {
                System.out.println("Classe discente");


                System.out.println("***Menu***");
                System.out.println("1. Crea un nuovo discente");
                System.out.println("2. Aggiorna un discente");
                System.out.println("3. Visualizza la lista di discenti");
                System.out.println("4. Elimina un discenti");
                System.out.println("9. Exit");
                System.out.print("inserisci la tua scelta: ");

                // Read user input
                choice2 = scanner.nextInt();
                switch (choice2) {
                    case 1:
                        createDisc();
                        break;
                    case 2:
                        updateDisc();
                        break;
                    case 3:
                        readDisc();
                        break;
                    case 4:
                        deleteDisc();
                        break;
                    case 9:
                        System.out.println("exiting");
                        break;
                    default:
                        System.out.println("scelta errata. scegliere un numero da 1 a 8");
                }

            } else if (choice1 == 3) {
                System.out.println("Classe Corso");
                System.out.println("***Menu***");
                System.out.println("1. Crea un nuovo corso");
                System.out.println("2. Aggiorna un corso");
                System.out.println("3. Visualizza la lista dei corsi");
                System.out.println("4. Elimina un corso");
                System.out.println("9. Exit");
                System.out.print("inserisci la tua scelta: ");
                choice2 = scanner.nextInt();
                switch (choice2) {
                    case 1:
                        createCor();
                        break;
                    case 2:
                        updateCor();
                        break;
                    case 3:
                        readCor();
                        break;
                    case 4:
                        deleteCor();
                        break;
                    case 9:
                        System.out.println("exiting");
                        break;



                    default:
                        System.out.println("scelta errata. scegliere 1");
                }

            }
        }
        while (choice1 != 4);
        scanner.close();


    }

    private static void readDoc() {
        System.out.println("ecco la lista dei docenti: ");
        DocenteService oDocenteService = new DocenteService();
        List<Docente> listaDocenti = oDocenteService.readDocente();
        int i = 0;
        while (i < listaDocenti.size()) {
            System.out.println(listaDocenti.get(i).getid() + " " + listaDocenti.get(i).getCognome() + " " + listaDocenti.get(i).getNome());
            i++;
        }

    }

    private static void readDisc() {
        System.out.println("ecco la lista dei discenti: ");
        DiscenteService oDiscenteService = new DiscenteService();
        List<Discente> listaDiscenti = oDiscenteService.readDiscente();
        int i = 0;
        while (i < listaDiscenti.size()) {
            System.out.println(listaDiscenti.get(i).getid() + " " + listaDiscenti.get(i).getCognome() + " " + listaDiscenti.get(i).getNome() + " " + listaDiscenti.get(i).getMatricola() + " " + listaDiscenti.get(i).getData_nascita());
            i++;
        }


    }
    private static void readCor() {
        System.out.println("ecco la lista corsi: ");
        CorsoService oCorsoService = new CorsoService();
        List<Corso> listaCorso = oCorsoService.readCorso();
        DocenteService docenteservice = new DocenteService();
        List<Docente> listaDocente = docenteservice.readDocente();
        for(Corso c:listaCorso){

        int i = 0;
        while (i < listaCorso.size()) {
            if(c.getDocente().getid() == listaDocente.get(i).getid()){
                System.out.println(listaCorso.get(i).getId()+" "+listaCorso.get(i).getNome()+" "+listaCorso.get(i).getData_inizio()+" "+listaCorso.get(i).getDurata()+" " +
                        " "+listaCorso.get(i).getDocente().getid()+" "+listaDocente.get(i).getNome()+" "+listaDocente.get(i).getCognome());

            }
            i++;
        }


        }
    }


    private static void createDisc() {
        System.out.println("inserisci nome: ");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.next();
        System.out.println("inserisci cognome: ");
        String cognome = scanner.next();
        System.out.println("inserisci matricola: ");
        String matricola = scanner.next();
        System.out.print("Inserisci data di nascita (formato yyyy-MM-dd): ");
        String data_nascita = scanner.next();
        DiscenteService oDiscenteService = new DiscenteService();
        oDiscenteService.create(nome, cognome, matricola, data_nascita);


    }
        private static void createCor() {
            System.out.println("inserisci nome: ");
            Scanner scanner = new Scanner(System.in);
            String nome = scanner.next();
            LocalDate dataInserita = null;

            // Definire un formato per la data
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            boolean dataValida = false;
            while (!dataValida) {
                try {
                    // Chiedi all'utente di inserire una data
                    System.out.print("Inserisci una data (formato dd/MM/yyyy): ");
                    String input = scanner.next();

                    // Converte la stringa in LocalDate
                    dataInserita = LocalDate.parse(input, formatter);
                    dataValida = true; // Se non c'è eccezione, la data è valida

                } catch (DateTimeParseException e) {
                    System.out.println("Formato non valido. Riprova.");
                }
            }

            System.out.println("inserisci durata corso: ");
            String durata = scanner.next();
            scanner.nextLine();

            System.out.println("ecco la lista dei docenti: ");

            DocenteService oDocenteService = new DocenteService();
            List<Docente> listaDocenti= oDocenteService.readDocente();
            for(int n = 0; n < listaDocenti.size(); n++){
                System.out.println(listaDocenti.get(n).getid()+" "+listaDocenti.get(n).getCognome()+" "+listaDocenti.get(n).getNome());
            }

            System.out.println("Inserisci id del docente da inserire: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            for(int m = 0; m < listaDocenti.size(); m++){
                if(listaDocenti.get(m).getid() == id){
                    Docente docente = listaDocenti.get(m);
                    CorsoService oCorsoService = new CorsoService();
                    oCorsoService.create(nome, dataInserita, durata, docente);
                }

            }


        }









    private static void createDoc() {
        System.out.println("inserisci nome: ");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.next();
        System.out.println("inserisci cognome: ");
        String cognome = scanner.next();
        DocenteService oDocenteService = new DocenteService();
        oDocenteService.create(nome, cognome);

    }

    private static void deleteDisc() {
        System.out.println("Elimina il discente con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        DiscenteService oDiscenteService = new DiscenteService();
        oDiscenteService.delete(id);


    }

    private static void deleteDoc() {
        System.out.println("Elimina il docente con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        DocenteService oDocenteService = new DocenteService();
        oDocenteService.delete(id);


    }
    private static void deleteCor() {
        System.out.println("Elimina il corso con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        CorsoService oCorsoService = new CorsoService();
        oCorsoService.delete(id);
    }

    private static void updateDoc() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci l'id del docente da modificare:");
        int id = scanner.nextInt();
        System.out.println("inserisci il nuovo nome:");
        String nome = scanner.next();
        System.out.println("inserisci il nuovo cognome:");
        String cognome = scanner.next();
        DocenteService oDocenteService = new DocenteService();
        oDocenteService.update(id, nome, cognome);

    }

    private static void updateDisc() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci l'id del discente da modificare:");
        int id = scanner.nextInt();
        System.out.println("inserisci il nuovo nome:");
        String nome = scanner.next();
        System.out.println("inserisci il nuovo cognome:");
        String cognome = scanner.next();
        System.out.println("inserisci la nuova matricola:");
        String matricola = scanner.next();
        System.out.print("Inserisci data di nascita (formato yyyy-MM-dd): ");
        String data_nascita = scanner.next();
            DiscenteService oDiscenteService = new DiscenteService();
            oDiscenteService.update(id, nome, cognome, matricola, data_nascita);


        }
        private static void updateCor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci l'id del corso da modificare:");
        int id = scanner.nextInt();
        System.out.println("inserisci il nuovo nome:");
        String nome = scanner.next();

            LocalDate dataInserita = null;

            // Definire un formato per la data
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            boolean dataValida = false;
            while (!dataValida) {
                try {
                    // Chiedi all'utente di inserire una data
                    System.out.print("Inserisci una nuova data (formato dd/MM/yyyy): ");
                    String input = scanner.next();

                    // Converte la stringa in LocalDate
                    dataInserita = LocalDate.parse(input, formatter);
                    dataValida = true; // Se non c'è eccezione, la data è valida

                } catch (DateTimeParseException e) {
                    System.out.println("Formato non valido. Riprova.");
                }
            }
        String data_inizio = scanner.next();
        System.out.println("inserisci la nuova durata:");
        String durata = scanner.next();
            System.out.println("Inserisci id del docente da inserire: ");
            int idoc= scanner.nextInt();
            DocenteService oDocenteService = new DocenteService();
            List<Docente> listaDocenti= oDocenteService.readDocente();
            for(int m = 0; m < listaDocenti.size(); m++){
                if(listaDocenti.get(m).getid() == id){
                    Docente docente = listaDocenti.get(m);
                    CorsoService oCrosoService = new CorsoService();
                    oCrosoService.update(id,nome, dataInserita, durata, docente);
                }
                System.out.println();
            }


        }

    }


