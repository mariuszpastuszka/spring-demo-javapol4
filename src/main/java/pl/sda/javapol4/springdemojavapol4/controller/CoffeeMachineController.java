package pl.sda.javapol4.springdemojavapol4.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.javapol4.springdemojavapol4.service.CoffeeMachineService;

@Slf4j
@Controller
@RequestMapping("/coffee")
public class CoffeeMachineController {

    private static final String COFFEE_MACHINES = "coffeeMachines";
    private final CoffeeMachineService coffeeMachineService;

    public CoffeeMachineController(CoffeeMachineService coffeeMachineService) {
        this.coffeeMachineService = coffeeMachineService;
    }

    @GetMapping("/all-coffee-machines")
    public String myCoffeeMachines(Model model) {
        log.info("my all coffee machines request");

        var allCoffeeMachines = coffeeMachineService.giveMeMyCoffeeMachines();
        model.addAttribute(COFFEE_MACHINES, allCoffeeMachines);

        return "coffees/my-coffees";
    }
}
