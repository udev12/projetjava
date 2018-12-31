/**
 * Application créée par Yann MALOULA le 30 Décembre 2018
 */

package com.projet.projet.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "randonnees")
public class Randonnees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id_r;
    private String nom_r;
    private String lieu_r;
    private Float duree_r;
    private Float note_r;
    private Integer resto_r;
    private Float niv_r;
    private Integer fam_r;
    private Integer adnim_r;
    private Float dist_r;
    private  String fiche_r;
    private String maps_r;

    public Randonnees() {
    }

    public Randonnees(Integer id_r, String nom_r, String lieu_r, Float duree_r, Float note_r, Integer resto_r, Float niv_r, Integer fam_r, Integer adnim_r, Float dist_r, String fiche_r, String maps_r) {
        this.id_r = id_r;
        this.nom_r = nom_r;
        this.lieu_r = lieu_r;
        this.duree_r = duree_r;
        this.note_r = note_r;
        this.resto_r = resto_r;
        this.niv_r = niv_r;
        this.fam_r = fam_r;
        this.adnim_r = adnim_r;
        this.dist_r = dist_r;
        this.fiche_r = fiche_r;
        this.maps_r = maps_r;
    }

    @ManyToMany(mappedBy = "randos") // relation plusieurs à plusieurs
    @JsonBackReference
    private List<Inscrits> inscrits;

    public List<Inscrits> getInscrits() {
        return inscrits;
    }

    public void setInscrits(List<Inscrits> inscrits) {
        this.inscrits = inscrits;
    }

    public Integer getId_r() {
        return id_r;
    }

    public void setId_r(Integer id_r) {
        this.id_r = id_r;
    }

    public String getNom_r() {
        return nom_r;
    }

    public void setNom_r(String nom_r) {
        this.nom_r = nom_r;
    }

    public String getLieu_r() {
        return lieu_r;
    }

    public void setLieu_r(String lieu_r) {
        this.lieu_r = lieu_r;
    }

    public Float getDuree_r() {
        return duree_r;
    }

    public void setDuree_r(Float duree_r) {
        this.duree_r = duree_r;
    }

    public Float getNote_r() {
        return note_r;
    }

    public void setNote_r(Float note_r) {
        this.note_r = note_r;
    }

    public Integer getResto_r() {
        return resto_r;
    }

    public void setResto_r(Integer resto_r) {
        this.resto_r = resto_r;
    }

    public Float getNiv_r() {
        return niv_r;
    }

    public void setNiv_r(Float niv_r) {
        this.niv_r = niv_r;
    }

    public Integer getFam_r() {
        return fam_r;
    }

    public void setFam_r(Integer fam_r) {
        this.fam_r = fam_r;
    }

    public Integer getAdnim_r() {
        return adnim_r;
    }

    public void setAdnim_r(Integer adnim_r) {
        this.adnim_r = adnim_r;
    }

    public Float getDist_r() {
        return dist_r;
    }

    public void setDist_r(Float dist_r) {
        this.dist_r = dist_r;
    }

    public String getFiche_r() {
        return fiche_r;
    }

    public void setFiche_r(String fiche_r) {
        this.fiche_r = fiche_r;
    }

    public String getMaps_r() {
        return maps_r;
    }

    public void setMaps_r(String maps_r) {
        this.maps_r = maps_r;
    }

    @Override
    public String toString() {
        return "Randonnees{" +
                "id_r=" + id_r +
                ", nom_r='" + nom_r + '\'' +
                ", lieu_r='" + lieu_r + '\'' +
                ", duree_r=" + duree_r +
                ", note_r=" + note_r +
                ", resto_r=" + resto_r +
                ", niv_r=" + niv_r +
                ", fam_r=" + fam_r +
                ", adnim_r=" + adnim_r +
                ", dist_r=" + dist_r +
                ", fiche_r='" + fiche_r + '\'' +
                ", maps_r='" + maps_r + '\'' +
//                ", inscrit=" + inscrit +
                '}';
    }

}
