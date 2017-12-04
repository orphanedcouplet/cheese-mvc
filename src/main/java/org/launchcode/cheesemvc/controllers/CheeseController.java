package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.launchcode.cheesemvc.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    // request path: "cheese/"
    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("fromages", CheeseData.getAll());
        model.addAttribute("title", "Mes Fromages");
        return "cheese/index";
    }

    // request path: "cheese/add"
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Ajoutez Un Fromage");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    // request path: "cheese/add"
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese nouveauFromage, Errors errors, Model model) {
//        Cheese nouveauFromage = new Cheese(fromageNom, descriptionFromage);
//        fromages.add(nouveauFromage);
//        return "redirect";

        if (errors.hasErrors()) {
            model.addAttribute("title", "Ajoutez Un Fromage");
            return "cheese/add";
        }

        CheeseData.add(nouveauFromage);
        // redirect to "cheese/"
        return "redirect:";
    }

    // request path: "cheese/remove"
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("title", "Supprimez Un Fromage");
        model.addAttribute("fromages", CheeseData.getAll());
        return "cheese/remove";
    }

    // request path: "cheese/remove"
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] idsDeFromage) {

        // TODO figure out what is broken here
        for (int idDeFromage: idsDeFromage) {
            CheeseData.remove(idDeFromage);
        }

        // redirect to "cheese/"
        return "redirect:";
    }

}
