package pl.sda.javapol4.springdemojavapol4.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.javapol4.springdemojavapol4.service.CoffeeMachineService;

@Slf4j
@Controller
@RequestMapping("/coffee")
public class CoffeeMachineController {

    private final CoffeeMachineService coffeeMachineService;

    public CoffeeMachineController(CoffeeMachineService coffeeMachineService) {
        this.coffeeMachineService = coffeeMachineService;
    }

    @GetMapping("/all-coffee-machines")
    public String myCoffeeMachines() {
        log.info("my all coffee machines request");

        var allCoffeeMachines = coffeeMachineService.giveMeMyCoffeeMachines();

        return "coffees/my-coffees";
    }
}
