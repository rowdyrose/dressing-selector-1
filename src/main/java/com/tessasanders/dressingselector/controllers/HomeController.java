package com.tessasanders.dressingselector.controllers;

import com.tessasanders.dressingselector.models.data.DressingDao;
import com.tessasanders.dressingselector.models.forms.Dressing;
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
    public String DisplaySearchForm(Model model,
                                    @RequestParam String surgicalWound,
                                    @RequestParam(required = false) String debridementPerformed,
                                    @RequestParam(required = false) String thickness,
                                    @RequestParam(required = false) String drainage) {

        ArrayList<Dressing> dressingData = (ArrayList<Dressing>) dressingDao.findAll();
        ArrayList<Dressing> results = new ArrayList<>();

         for (Dressing item : dressingData) {
             if (surgicalWound != null && !surgicalWound.toLowerCase().equals(item.getDebridementRequired().toLowerCase())) {
                 if (debridementPerformed != null && !debridementPerformed.toLowerCase().equals(item.getDebridementRequired().toLowerCase())) {
                     continue;
                 }
             }
             // pulls results is wound is marked as debrided
// searches based on thickness selected
             if (thickness != null && !thickness.toLowerCase().equals(item.getThicknessRequirement()) && !item.getThicknessRequirement().equals("any")) {
                 continue;
             }  // searches based on drainage selected
            if (drainage != null && !drainage.toLowerCase().equals(item.getDrainageRequirement().toLowerCase()) && !item.getDrainageRequirement().equals("any")) {
                continue;
            }
            results.add(item);
       }
        model.addAttribute("title", "Wound Care Dressing Finder Results");
        model.addAttribute("surgicalWound", surgicalWound);
        model.addAttribute("debridementPerformed", debridementPerformed);
        model.addAttribute("thickness", thickness);
        model.addAttribute("drainage", drainage);
        model.addAttribute("results", results);


        return "results";
    }
}