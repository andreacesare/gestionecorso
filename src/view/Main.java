package view;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Discente;
import model.Docente;
import service.DiscenteService;
import service.DocenteService;

import java.util.*;




public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice1;
        int choice2;

        do {
            System.out.println("1.Docente \n 2.Discente \n 3.Exit");
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

            }
        }
        while (choice1 != 3);
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

    }

