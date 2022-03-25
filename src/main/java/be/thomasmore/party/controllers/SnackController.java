package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Snack;
import be.thomasmore.party.repositories.SnackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SnackController {

    @Autowired
    private SnackRepository snackRepository;

    @GetMapping({"/snacklist","/snacklist/*"})
    public String snackList(Model model) {
        Iterable<Snack> snacks = snackRepository.findAll();
        long nrOfSnacks = snackRepository.count();
        model.addAttribute("nrOfSnacks", nrOfSnacks);
        model.addAttribute("snacks", snacks);
        return "snacklist";
    }

    @GetMapping({"/snackdetails/{id}", "/snackdetails"})
    public String snackdetails(Model model, @PathVariable(required = false) Integer id) {

        return "snackdetails";
    }
}
