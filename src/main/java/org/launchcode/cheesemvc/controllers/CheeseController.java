package org.launchcode.cheesemvc.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

//    static HashMap<String, String> fromages = new HashMap<>();
    static ArrayList<Cheese> fromages = new ArrayList<>();

    // request path: "cheese/"
    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("fromages", fromages);
        model.addAttribute("title", "Mes Fromages");
        return "cheese/index";
    }

    // request path: "cheese/add"
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Ajoutez Un Fromage");
        return "cheese/add";
    }

    // request path: "cheese/add"
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String fromageNom, @RequestParam String descriptionFromage) {
        fromages.add(new Cheese(fromageNom, descriptionFromage));

        // redirect to "cheese/"
        return "redirect:";
    }

    // request path: "cheese/remove"
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("title", "Supprimez Un Fromage");
        model.addAttribute("fromages", fromages);
        return "cheese/remove";
    }

    // request path: "cheese/remove"
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam ArrayList<String> fromagesASupprimer) {

        for (String fromageASupprimer : fromagesASupprimer) {
            fromages.remove(fromageASupprimer);
        }

        // redirect to "cheese/"
        return "redirect:";
    }

}
