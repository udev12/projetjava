/**
 * Application créée par Yann MALOULA le 30 Décembre 2018
 */

package com.projet.projet.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED) héritage
@Table(name = "inscrits")
public class Inscrits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id_i;

    //@Column(name = "nom")
    private String nom;
    private String prenom;
    private String mail_i;
    private Float age_i;
    private Integer nb_enfant_i;
    private LocalDate date_i;
    private Integer admin_i;
    private Integer modo_i;

    public Inscrits() {
    }

    public Inscrits(Long id_i, String nom, String prenom, String mail_i, Float age_i, Integer nb_enfant_i, LocalDate date_i, Integer admin_i, Integer modo_i) {
        this.id_i = id_i;
        this.nom = nom;
        this.prenom = prenom;
        this.mail_i = mail_i;
        this.age_i = age_i;
        this.nb_enfant_i = nb_enfant_i;
        this.date_i = date_i;
        this.admin_i = admin_i;
        this.modo_i = modo_i;
    }

    @ManyToMany(fetch = FetchType.EAGER) // relation plusieurs à plusieurs
    @JoinTable(name = "inscrits_randonnees",
            joinColumns = @JoinColumn(name = "inscrit_id"),
            inverseJoinColumns = @JoinColumn(name = "rando_id"))
    @JsonManagedReference
    private List<Randonnees> randos;

    public List<Randonnees> getRandos() {
        return randos;
    }

    public void setRandos(List<Randonnees> randos) {
        this.randos = randos;
    }

    public Long getId_i() {
        return id_i;
    }

    public void setId_i(Long id_i) {
        this.id_i = id_i;
    }

    public String getNom() {
        return nom;
    }

    public void setNom_i(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail_i() {
        return mail_i;
    }

    public void setMail_i(String mail_i) {
        this.mail_i = mail_i;
    }

    public Float getAge_i() {
        return age_i;
    }

    public void setAge_i(Float age_i) {
        this.age_i = age_i;
    }

    public Integer getNb_enfant_i() {
        return nb_enfant_i;
    }

    public void setNb_enfant_i(Integer nb_enfant_i) {
        this.nb_enfant_i = nb_enfant_i;
    }

    public LocalDate getDate_i() {
        return date_i;
    }

    public void setDate_i(LocalDate date_i) {
        this.date_i = date_i;
    }

    public Integer getAdmin_i() {
        return admin_i;
    }

    public void setAdmin_i(Integer admin_i) {
        this.admin_i = admin_i;
    }

    public Integer getModo_i() {
        return modo_i;
    }

    public void setModo_i(Integer modo_i) {
        this.modo_i = modo_i;
    }

    @Override
    public String toString() {
        return "Inscrits{" +
                "id_i=" + id_i +
                ", nom_i='" + nom + '\'' +
                ", prenom_i='" + prenom + '\'' +
                ", mail_i='" + mail_i + '\'' +
                ", age_i=" + age_i +
                ", nb_enfant_i=" + nb_enfant_i +
                ", date_i=" + date_i +
                ", admin_i=" + admin_i +
                ", modo_i=" + modo_i +
//                ", rando=" + rando +
                '}';
    }

}
