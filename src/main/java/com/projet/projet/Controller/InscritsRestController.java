/**
 * Application créée par Yann MALOULA le 30 Décembre 2018
 */

package com.projet.projet.Controller;

import com.projet.projet.Model.Inscrits;
import com.projet.projet.Repository.InscritsRepository;
import com.projet.projet.Service.InscritsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// Le controller formatte les données renvoyées par les services lors des appels des consommateurs
@RestController // les méthodes du repository ne fonctionnent qu'avec @ResstController
@RequestMapping("/rando")
public class InscritsRestController {

    // L'annotation "Autowired" permet d'injecter un bean dans un autre
    @Autowired(required = false) // si le paramètre "required" n'a pas la valeur "false", alors on a une exception
    InscritsService inscritService;

    // L'annotation "Autowired" permet d'injecter un bean dans un autre
    @Autowired(required = false) // si le paramètre "required" n'a pas la valeur "false", alors on a une exception
    InscritsRepository inscritsRepository;

    // Dans le navigateur, saisir l'url suivant : http://localhost:8059/rando/count
    @RequestMapping("/count") // définit des mappings qui permettent d'intercepter des requêtes HTML (GET, POST, PUT, ...)
    public Long count(){
        return inscritService.countInscrits();
    }

    // Dans le navigateur, saisir l'url suivant : http://localhost:8059/rando/{id} (ex : localhost:8059/rando/2 pour un id = 2
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Inscrits trouverInscrit(@PathVariable(value = "id") Long id) throws Exception {
        return  inscritService.findById(id);
    }

}
