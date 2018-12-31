/**
 * Application créée par Yann MALOULA le 30 Décembre 2018
 */

package com.projet.projet.Service;

import com.projet.projet.Model.Inscrits;
import com.projet.projet.Repository.InscritsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

// Le service expose les fonctionnalités disponibles et appelle les méthodes du repository
@Service
public class InscritsService {

    // L'annotation "Autowired" permet d'injecter un bean dans un autre
    @Autowired(required = false) // si le paramètre "required" n'a pas la valeur "false", alors on a une exception
    private InscritsRepository inscritsRepository;

    // Rechercher à partie de l'id
    public Inscrits findById(Long id) throws Exception{
        //Optional<Inscrits> inscrits = inscritsRepository.findById(id);
        Optional<Inscrits> inscrits = inscritsRepository.findById(id); // on utilise la fonction mise à disposition par le PagingAndSortingRepository
        //return  inscrits;
        if(inscrits.isPresent()){
            return inscrits.get();
        }
        throw new Exception("L'inscrit n'a pas été trouvé");
    }

    // Compter le nombre d'inscrits
    public Long countInscrits(){
        Long i = inscritsRepository.count(); // on utilise la fonction mise à disposition par le PagingAndSortingRepository
        return i;
    }

    // Créer un nouvel inscrit
    public Inscrits creerInscrit(/*Inscrits inscrits*/){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Créer un nouvel inscrit : ");
        //scanner = new Scanner(System.in);
        System.out.println("Saisir le nom : ");
        String nom = scanner.nextLine();
        System.out.println("Saisir le prénom : ");
        String prenom = scanner.nextLine();
        System.out.println("Saisir l'adresse électronique : ");
        String mail = scanner.nextLine();
        System.out.println("Saisir l'âge : ");
        Float age = scanner.nextFloat();
        System.out.println("Saisir le nombre d'enfants : ");
        Integer nbEnf = scanner.nextInt();
        scanner = new Scanner(System.in);
        System.out.println("Saisir la date d'inscription : ");
        String date = scanner.nextLine();
        System.out.println("Saisir l'admin : ");
        Integer admin = scanner.nextInt();
        System.out.println("Saisir le modo : ");
        Integer modo = scanner.nextInt();
        Inscrits inscrits = new Inscrits(0l /*compteur.incrementAndGet()*/, nom, prenom, mail, age, nbEnf, LocalDate.parse(date), admin, modo);
        return inscritsRepository.save(inscrits); // on utilise la fonction mise à disposition par le PagingAndSortingRepository
        //return inscritsRepository.save(new Inscrits(16l, "toto", "wa", "w.toto@gmail.com", 44f, 2, LocalDate.parse("2018-12-18"), 0, 0));
    }

    // Supprimer un incrit à partir de son id
    public void deleteInscrit(Long id) {
        inscritsRepository.deleteById(id); // on utilise la fonction mise à disposition par le PagingAndSortingRepository
    }

    public Page<Inscrits> findAllInscritsPaging(Integer page, Integer size, String sortDirection, String sortProperty){
        PageRequest pageable = new PageRequest(page, size, Sort.Direction.fromString(sortDirection), sortProperty);
        return inscritsRepository.findAll(pageable);
    }

}
