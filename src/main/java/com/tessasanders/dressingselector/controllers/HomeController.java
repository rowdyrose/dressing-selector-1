package com.tessasanders.dressingselector.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping(value = "")
    public String index(Model model) {
       model.addAttribute("title", "Wound Care Dressing Selector");
        return "index";
    }
    //handler to process and display search results
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String DisplaySearchForm(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }
}
