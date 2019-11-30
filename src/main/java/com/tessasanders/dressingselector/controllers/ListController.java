package com.tessasanders.dressingselector.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.HashMap;

@Controller
public class ListController {

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {
        columnChoices.put("dressingName", "Dressing Name");
        columnChoices.put("drainageAmount", "Drainage Amount Required");
        columnChoices.put("thicknessRequirement", "Thickness required");
        columnChoices.put("debridementRequired", "Debridement Required");
        columnChoices.put("frequencyAllowed", "Frequency Allowed");
    }
    public String list(Model model) {

        model.addAttribute("columns", columnChoices);

        return "list";
    }

}
