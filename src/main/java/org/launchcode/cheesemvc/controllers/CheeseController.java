package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    static ArrayList<String> fromages = new ArrayList<>();

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
    public String processAddCheeseForm(@RequestParam String fromageNom) {
        fromages.add(fromageNom);

        // redirect to "cheese/"
        return "redirect:";
    }

}
