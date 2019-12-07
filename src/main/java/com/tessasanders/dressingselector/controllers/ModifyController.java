package com.tessasanders.dressingselector.controllers;

import com.tessasanders.dressingselector.models.data.DressingDao;
import com.tessasanders.dressingselector.models.forms.Dressing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class ModifyController {

    @Autowired
    private DressingDao dressingDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddForm(Model model) {
        model.addAttribute("title", "Add Dressing Item");
        model.addAttribute(new Dressing());
        return "/add";

    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddForm(@ModelAttribute @Valid Dressing newDressing, Errors errors, @RequestParam int categoryId, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Dressing");
            return "/add";
        }

        dressingDao.save(newDressing);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("dressings", dressingDao.findAll());
        model.addAttribute("title", "Remove Dressing");
        return "/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveDressingForm(@RequestParam Long[] dressingIds) {

        for (Long dressingId : dressingIds) {
            dressingDao.delete(dressingId);
        }

        return "redirect:";
    }

}
