/**
 * Application créée par Yann MALOULA le 30 Décembre 2018
 */

package com.projet.projet;

import com.projet.projet.Model.Inscrits;
import com.projet.projet.Repository.InscritsRepository;
import com.projet.projet.Service.InscritsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
//import java.util.function.Consumer

//@Component // la classe est utilisée comme un composant
public class MyRunner /*implements CommandLineRunner*/ { // avec l'interface CommandLineRunner, Spring boot va automatiquement appeler
            // la méthode run (voir plus bas)

    @Autowired // L'annotation "Autowired" permet d'injecter un bean dans un autre
    public InscritsRepository inscritsRepository;

    @Autowired // L'annotation "Autowired" permet d'injecter un bean dans un autre
    InscritsService inscritsService;

    public Inscrits inscrits;

    private Object SQLException;

    private final AtomicLong compteur = new AtomicLong(); // permet de compter le nombre d'enregistrements

    public void run(String... strings) throws Exception {

        // Rechercher une inscrit avec son id
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un id : ");
        Long id = scanner.nextLong();
        Inscrits i = inscritsService.findById(id);
        System.out.println(i);
        System.out.println("");
        //System.out.println(i.getRandos().size());

        // Afficher le nombre d'inscrits
        Long nb = inscritsService.countInscrits();
        System.out.println("Il y a : " + nb + " inscrits.");
        System.out.println("");

        // Créer un nouvel inscrit
        //nb = nb + 1;
        /*System.out.println("Créer un nouvel inscrit : ");
        scanner = new Scanner(System.in);
        System.out.println("Saisir le nom : ");
        String nom = scanner.nextLine();
        System.out.println("Saisir le prénom : ");
        String prenom = scanner.nextLine();
        System.out.println("Saisir l'adresse électronique : ");
        String mail = scanner.nextLine();
        scanner = new Scanner(System.in);
        System.out.println("Saisir l'âge : ");
        Float age = scanner.nextFloat();
        scanner = new Scanner(System.in);
        System.out.println("Saisir le nombre d'enfants : ");
        Integer nbEnf = scanner.nextInt();
        scanner = new Scanner(System.in);
        System.out.println("Saisir la date d'insCription : ");
        String date = scanner.nextLine();
        scanner = new Scanner(System.in);
        System.out.println("Saisir l'admin : ");
        Integer admin = scanner.nextInt();
        System.out.println("Saisir le modo : ");
        Integer modo = scanner.nextInt();
        Inscrits inscrits = new Inscrits(0l /*compteur.incrementAndGet()*//*, nom, prenom, mail, age, nbEnf, LocalDate.parse(date), admin, modo);*/

        inscritsService.creerInscrit(/*inscrits*/); // on appelle la méthode déclarée dans InscritsRepository
        //System.out.println("");

        // Afficher le nombre d'inscrits
        nb = inscritsService.countInscrits(); // on appelle la méthode déclarée dans InscritsRepository
        System.out.println("Il y a maintenant : " + nb + " inscrits.");
        System.out.println("");

        // Rechercher un inscrit à partir de son nom
        List<Inscrits> list = inscritsRepository.findByNom("Maloula"); // on appelle la méthode déclarée dans InscritsRepository
        // On parcourt la collection grâce au stream
        Stream<Inscrits> str_i = list.stream();
        str_i.forEach(System.out::println);

        // Rechercher un inscrit à partir de son nom et de son prénom
        list = inscritsRepository.findByNomAndPrenom("Durand", "Bernard"); // on appelle la méthode déclarée dans InscritsRepository
        // On parcourt la collection grâce au stream
        str_i = list.stream();
        str_i.forEach(System.out::println);

        // Rechercher un inscrit à partir de son nom écrit avec des lettres majuscules et/ou minuscules
        PageRequest pageRequest = new PageRequest(0, 1, Sort.Direction.ASC, "nom"); // on trie par ordre alphabétique les noms
        Page<Inscrits> page = inscritsRepository.findByNomIgnoreCase("dumas", pageRequest); // on appelle la méthode déclarée dans InscritsRepository
        page.forEach(System.out::println);
        System.out.println("");

        // Supprimer un inscrit
        //scanner = new Scanner(System.in);
        System.out.println("Supprimer un inscrit");
        System.out.println("Saisir un id : ");
        Long cle = scanner.nextLong();
        inscritsService.deleteInscrit(cle);

        // Afficher le nombre d'inscrits
        nb = inscritsService.countInscrits(); // on appelle la méthode déclarée dans InscritsRepository
        System.out.println("Il y a maintenant : " + nb + " inscrits.");
        System.out.println("");

    }

    private static void print(String s) {
        System.out.println(s);
    }


//        Connection connexion = initConnection();
//        Statement statement = connexion.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM Inscrits");
//        while ( resultSet.next() ) {
//            print(resultSet.getId("id_i"));
//        }

       /* String url = "jdbc:mysql://localhost:3306/rando63";
        String user = "root";
        String pwd = "";

        java.sql.Connection connexion = null;

        try {
            connexion = java.sql.DriverManager.getConnection(url, user, pwd);

        } catch (java.sql.SQLException e) {
            //Problème de connexion à la base !
            System.out.println(e.getMessage());
        }

        // L'object connexion va nous permettre d'effectuer des requêtes...
        try {
            // Lire bdd
            Statement statement = connexion.createStatement();
            String query = "SELECT * FROM Inscrits";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("Id :" + resultSet.getInt("id_i"));
                System.out.println("Nom :" + resultSet.getString("nom_i"));
                System.out.println("Prénom :" + resultSet.getString("prenom_i"));
                System.out.println("Mail :" + resultSet.getString("mail_i"));
                System.out.println("Age :" + resultSet.getString("age_i"));
                System.out.println("Salaire :" + resultSet.getString("salaire"));
            }
            // Ecrire dans la bdd

//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Salaire?");
//            Double salaire = scanner.nextDouble();


//            query = "INSERT INTO Employe(nom, prenom, matricule, dateembauche, salaire) VALUES('Mami', 'Isi', 'Ha', '2017-01-20', " + salaire + ")";
//            int status = statement.executeUpdate(query); // nb de ligne insérées
//            System.out.println(status + "ligne(s) insérée(s)");

            //return connexion;
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

//    private void print(Object t) {
//        System.out.print(t);
//    }*/



}
