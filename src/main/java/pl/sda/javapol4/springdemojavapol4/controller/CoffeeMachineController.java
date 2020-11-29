package pl.sda.javapol4.springdemojavapol4.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.javapol4.springdemojavapol4.service.CoffeeMachineService;

@Slf4j
@Controller
@RequestMapping("/coffee")
public class CoffeeMachineController {

    private static final String COFFEE_MACHINES = "coffeeMachines";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private final CoffeeMachineService coffeeMachineService;

    public CoffeeMachineController(CoffeeMachineService coffeeMachineService) {
        this.coffeeMachineService = coffeeMachineService;
    }

    // user name and surname
    // ?imie=mariusz&nazwisko=pastuszka
    @GetMapping("/all-coffee-machines")
    public String myCoffeeMachines(Model model,
                                   @RequestParam(value = "imie", required = false, defaultValue = "Janek") String name,
                                   @RequestParam(value = "nazwisko", required = false, defaultValue = "Kowalski") String surname) {
        log.info("my all coffee machines request");
        log.info("name = [{}], surname = [{}]", name, surname);
//        log.info("name = [${name}], surname = [${surname}]");-- string interpolation

        var allCoffeeMachines = coffeeMachineService.giveMeMyCoffeeMachines();
        model.addAttribute(COFFEE_MACHINES, allCoffeeMachines);
        model.addAttribute(NAME, name);
        model.addAttribute(SURNAME, surname);

        return "coffees/my-coffees";
    }
}
