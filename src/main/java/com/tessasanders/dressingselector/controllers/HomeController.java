package com.tessasanders.dressingselector.controllers;

import com.tessasanders.dressingselector.models.data.DressingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    private DressingDao dressingDao;

    @RequestMapping(value = "")
    public String index(Model model) {
       model.addAttribute("title", "Wound Care Dressing Selector");
        return "index";
    }
    //handler to process and display search results
    @RequestMapping(value = "results", method = RequestMethod.GET)
    public String DisplaySearchForm(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {

        ArrayList<dressingData> DressingData = dressingDao.findAll();

        model.addAttribute("searchType", searchType);
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("columns", ListController.columnChoices);
        return "results";
    }
}
