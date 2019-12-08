package com.tessasanders.dressingselector.controllers;

import com.tessasanders.dressingselector.models.data.DressingDao;
import com.tessasanders.dressingselector.models.forms.Dressing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ModifyController {

    @Autowired
    private DressingDao dressingDao;

    @RequestMapping(value = "additems", method = RequestMethod.GET)
    public String displayAddForm(Model model) {
        model.addAttribute("title", "Add Dressing Item");
        model.addAttribute(new Dressing());
        return "/editdressing";

    }

    @RequestMapping(value = "modify", method = RequestMethod.GET)
    public String DisplayModifyForm(Model model, @RequestParam(required = false) String id) {

        Dressing item = new Dressing();

        if (id != null) {
            Optional<Dressing> optionalDressing = dressingDao.findById(Long.parseLong(id));
            if (optionalDressing.isPresent()) {
                item = optionalDressing.get();
            }
        }

        model.addAttribute("item", item);
        return "modify";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String SaveDressing(Model model,
                               @RequestParam(required = false) String dressingId,
                               @RequestParam(required = true) String dressingName,
                               @RequestParam(required = false) String debridementRequired,
                               @RequestParam(required = false) String drainageRequirement,
                               @RequestParam(required = false) String thicknessRequirement,
                               @RequestParam(required = false) String frequencyAllowed) {

        Dressing item = new Dressing();
        if (dressingId != null) {
            item.setDressingId(Long.parseLong(dressingId));
        }

        item.setDebridementRequired(debridementRequired);
        item.setDrainageRequirement(drainageRequirement);
        item.setDressingName(dressingName);
        item.setThicknessRequirement(thicknessRequirement);
        item.setFrequencyAllowed(frequencyAllowed);
        dressingDao.save(item);

        return "redirect:supplylist";
    }


    @RequestMapping(value = "additems", method = RequestMethod.POST)
    public String processAddForm(Model model,
                                 @RequestParam (required = false) String dressingId,
                                 @RequestParam String dressingName,
                                 @RequestParam String debridementRequired,
                                 @RequestParam String drainageRequirement,
                                 @RequestParam String thicknessRequirement,
                                 @RequestParam String frequencyAllowed) {
        Dressing newDressing = new Dressing();
        newDressing.setDebridementRequired(debridementRequired);
        newDressing.setDrainageRequirement(drainageRequirement);
        newDressing.setDressingName(dressingName);
        newDressing.setThicknessRequirement(thicknessRequirement);
        newDressing.setFrequencyAllowed(frequencyAllowed);
        dressingDao.save(newDressing);
        return "redirect:supplylist";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("dressing", dressingDao.findAll());
        model.addAttribute("title", "Remove Dressing");
        return "/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveDressingForm(@RequestParam Long[] dressingIds) {
        for (Long dressingId : dressingIds) {
            dressingDao.deleteById(dressingId);
        }

        return "redirect:supplylist";
    }

}
