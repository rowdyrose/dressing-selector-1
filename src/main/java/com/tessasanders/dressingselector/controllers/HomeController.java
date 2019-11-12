package com.tessasanders.dressingselector.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class HomeController {

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("dressings", "dressings");
        model.addAttribute("title", "Dressing Selector");
        return "index";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String DisplaySearchForm(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String processSearchForm() {


    }


}
