package com.tessasanders.dressingselector.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    @RequestMapping(value = "")
    public String index(Model model) {

        ArrayList<String> dressings = new ArrayList<>();
        dressings.add("Alginate");
        dressings.add("ABD Pads");
        dressings.add("Bulky");

        model.addAttribute("dressings", dressings);
        model.addAttribute("title", "Dressing Selector");
        return "index";
    }

    @RequestMapping(value = "search")
    public String DisplaySearchForm(Model model) {
        model.addAttribute("title", "Search Dressings");
        return "results";
    }


}
