package org.launchcode.cheesemvc.controllers;

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

    static HashMap<String, String> fromages = new HashMap<>();

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
        fromages.put(fromageNom, descriptionFromage);

        // redirect to "cheese/"
        return "redirect:";
    }

}
