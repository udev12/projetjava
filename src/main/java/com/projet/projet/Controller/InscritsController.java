/**
 * Application créée par Yann MALOULA le 30 Décembre 2018
 */

package com.projet.projet.Controller;

import com.projet.projet.Model.Inscrits;
import com.projet.projet.Repository.InscritsRepository;
import com.projet.projet.Service.InscritsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// Le controller formatte les données renvoyées par les services lors des appels des consommateurs
@Controller // les méthodes du repository ne fonctionnent pas avec @Controller
//@RequestMapping("/Inscrits")
public class InscritsController {

    // L'annotation "Autowired" permet d'injecter un bean dans un autre
    @Autowired(required = false) // si le paramètre "required" n'a pas la valeur "false", alors on a une exception
    InscritsService inscritService;

    // L'annotation "Autowired" permet d'injecter un bean dans un autre
    @Autowired(required = false) // si le paramètre "required" n'a pas la valeur "false", alors on a une exception
    InscritsRepository inscritsRepository;

    // Dans le navigateur, saisir l'url suivant : http://localhost:8059/inscrits
    @GetMapping("/inscrits") // mapping pour intercepter uniquement de requêtes GET
    public String inscritsForm(Model model) {
        model.addAttribute("inscrits", new Tampon());
        return "inscrits";
    }

    // Dans le navigateur, saisir l'url suivant : http://localhost:8059/inscrits
    @PostMapping("/inscrits") // mapping pour intercepter uniquement de requêtes POST
    public String inscritsSubmit(@ModelAttribute Tampon inscrits) {
        return "affichage";
    }

}
