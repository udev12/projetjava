/**
 * Application créée par Yann MALOULA le 30 Décembre 2018
 */

package com.projet.projet.Controller;

import com.projet.projet.Model.Inscrits;
import com.projet.projet.Repository.InscritsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Objects;


// Cette classe a été créée pour remplacer la classe Inscrits (entité). Faute de temps, je n'ai pu faire fonctionner
// le controlleur avec l'entité Inscrits. Le type "date" a particulièrement posé problème. Ce qui explique le fait que
// la date soit déclarée en String dans la classe Tampon.
public class Tampon {

    // L'annotation "Autowired" permet d'injecter un bean dans un autre
    @Autowired(required = false) // si le paramètre "required" n'a pas la valeur "false", alors on a une exception
    InscritsRepository inscritsRepository;

    // Attributs du formaulaire web
    private Long id_f;
    private String nom_f;
    private String prenom_f;
    private String mail_f;
    private Float age_f;
    private Integer nb_enfant_f;
    private String date_f;
    private Integer admin_f;
    private Integer modo_f;

    public Tampon() {
    }

    public Tampon(Long id_f, String nom_f, String prenom_f, String mail_f, Float age_f, Integer nb_enfant_f, String date_f, Integer admin_f, Integer modo_f) {
        this.id_f = id_f;
        this.nom_f = nom_f;
        this.prenom_f = prenom_f;
        this.mail_f = mail_f;
        this.age_f = age_f;
        this.nb_enfant_f = nb_enfant_f;
        this.date_f = date_f;
        this.admin_f = admin_f;
        this.modo_f = modo_f;

        /*Inscrits inscrits = new Inscrits(
                0l, // on met une valeur par défaut, sachant que l'id s'auto-incrémente dans l'entité "Inscrits"
                nom_f,
                prenom_f,
                mail_f,
                age_f,
                nb_enfant_f,
                LocalDate.parse(date_f),
                admin_f,
                modo_f
        );

        inscritsRepository.save(inscrits);*/

    }

    public Long getId_f() {
        return id_f;
    }

    public void setId_f(Long id_f) {
        this.id_f = id_f;
    }

    public String getNom_f() {
        return nom_f;
    }

    public void setNom_f(String nom_f) {
        this.nom_f = nom_f;
    }

    public String getPrenom_f() {
        return prenom_f;
    }

    public void setPrenom_f(String prenom_f) {
        this.prenom_f = prenom_f;
    }

    public String getMail_f() {
        return mail_f;
    }

    public void setMail_f(String mail_f) {
        this.mail_f = mail_f;
    }

    public Float getAge_f() {
        return age_f;
    }

    public void setAge_f(Float age_f) {
        this.age_f = age_f;
    }

    public Integer getNb_enfant_f() {
        return nb_enfant_f;
    }

    public void setNb_enfant_f(Integer nb_enfant_f) {
        this.nb_enfant_f = nb_enfant_f;
    }

    public String getDate_f() {
        return date_f;
    }

    public void setDate_f(String date_f) {
        this.date_f = date_f;
    }

    public Integer getAdmin_f() {
        return admin_f;
    }

    public void setAdmin_f(Integer admin_f) {
        this.admin_f = admin_f;
    }

    public Integer getModo_f() {
        return modo_f;
    }

    public void setModo_f(Integer modo_f) {
        this.modo_f = modo_f;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tampon)) return false;
        Tampon tampon = (Tampon) o;
        return Objects.equals(getId_f(), tampon.getId_f()) &&
                Objects.equals(getNom_f(), tampon.getNom_f()) &&
                Objects.equals(getPrenom_f(), tampon.getPrenom_f()) &&
                Objects.equals(getMail_f(), tampon.getMail_f()) &&
                Objects.equals(getAge_f(), tampon.getAge_f()) &&
                Objects.equals(getNb_enfant_f(), tampon.getNb_enfant_f()) &&
                Objects.equals(getDate_f(), tampon.getDate_f()) &&
                Objects.equals(getAdmin_f(), tampon.getAdmin_f()) &&
                Objects.equals(getModo_f(), tampon.getModo_f());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_f(), getNom_f(), getPrenom_f(), getMail_f(), getAge_f(), getNb_enfant_f(), getDate_f(), getAdmin_f(), getModo_f());
    }

    @Override
    public String toString() {
        return "Tampon{" +
                "id_f=" + id_f +
                ", nom_f='" + nom_f + '\'' +
                ", prenom_f='" + prenom_f + '\'' +
                ", mail_f='" + mail_f + '\'' +
                ", age_f=" + age_f +
                ", nb_enfant_f=" + nb_enfant_f +
                ", date_f='" + date_f + '\'' +
                ", admin_f=" + admin_f +
                ", modo_f=" + modo_f +
                '}';
    }

    public Inscrits remplirEntiteInscrits() {
        Inscrits inscrits = new Inscrits(
                0l, // on met une valeur par défaut, sachant que l'id s'auto-incrémente dans l'entité "Inscrits"
                nom_f,
                prenom_f,
                mail_f,
                age_f,
                nb_enfant_f,
                LocalDate.parse(date_f),
                admin_f,
                modo_f
        );
        inscritsRepository.save(inscrits);
        return inscrits;
    }

}
