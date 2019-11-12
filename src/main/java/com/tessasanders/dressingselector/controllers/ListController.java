package com.tessasanders.dressingselector.controllers;

import com.tessasanders.dressingselector.models.DressingData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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

    public String listColumnValues(Model model, @RequestParam String column) {

        ArrayList<String> items = DressingData.findAll(column);
        model.addAttribute("title", "All " + columnChoices.get(column) + " Values");
        model.addAttribute("column", column);
        model.addAttribute("items", items);
        return "list-column";
    }
}
