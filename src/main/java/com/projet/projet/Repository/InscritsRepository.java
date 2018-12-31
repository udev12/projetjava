/**
 * Application créée par Yann MALOULA le 30 Décembre 2018
 */

package com.projet.projet.Repository;

import com.projet.projet.Model.Inscrits;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

// Le repository permet de mapper les données de la base dans les entités
public interface InscritsRepository extends /*CrudRepository<Inscrits, Long>*/PagingAndSortingRepository<Inscrits,Long>{

    // Rechercher par nom
    List<Inscrits> findByNom(String nom);

    // Rechercher par nom et prénom
    List<Inscrits> findByNomAndPrenom(String nom, String prenom);

    // Rechercher par nom ou prénom, sans tenir compte de la case
    @Query("select i from Inscrits i where lower(i.prenom) = lower(:nomOuPrenom) or lower(i.nom) = lower(:nomOuPrenom)")
    List<Inscrits> findByNomOrPrenomAllIgnoreCase(@Param("nomOuPrenom") String nomOuPrenom);

    // Rechercher par nom sans tenir compte de la case
    Page<Inscrits> findByNomIgnoreCase(String nom, Pageable pageable);

}
