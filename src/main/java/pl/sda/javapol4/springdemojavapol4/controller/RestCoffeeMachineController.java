package pl.sda.javapol4.springdemojavapol4.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.javapol4.springdemojavapol4.entity.CoffeeMachine;
import pl.sda.javapol4.springdemojavapol4.service.CoffeeMachineService;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestCoffeeMachineController {

    private static final Logger log = LoggerFactory.getLogger(RestCoffeeMachineController.class);
    private final CoffeeMachineService coffeeMachineService;

    public RestCoffeeMachineController(CoffeeMachineService coffeeMachineService) {
        this.coffeeMachineService = coffeeMachineService;
    }

    // Jackson
//    @GetMapping("/all-coffee-machines")
    @GetMapping(value = "/coffee-machines",
        produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE})
    public List<CoffeeMachine> myCoffeeMachines() {
        log.info("rest controller - all coffee machines");
        return coffeeMachineService.giveMeMyCoffeeMachines();
    }

    // /coffee-machines/1
    // /coffee-machines/250
    @GetMapping("/coffee-machines/{id}")
    public CoffeeMachine findCoffeeMachineById(@PathVariable("id") long idik) {
        log.info("find coffee machine by id: [{}]", idik);
        // ...
        return null;
    }

    // /coffee-machines/{producer}/model/{name}
    @GetMapping("/coffee-machines/{producer}/model/{name}")
    public CoffeeMachine findByProducerAndModelName(
        @PathVariable("producer") String producer, @PathVariable("name") String modelName) {
        log.info("find coffee machine by producer: [{}] and model name [{}]",
            producer, modelName);
        return null;
    }
    /** - my json
     * [
     *  {
     *      "key": value
     *  }
     * ]
     */

    /**
     * CRUD
     * Read - GET /coffee-machines - all
     * Read One - GET /coffee-machines/{id} - one
     * Create - POST - /coffee-machines
     * Delete - DELETE /coffee-machines/{id}
     * Update - PATCH - partial update /coffee-machines/{id}
     * Update - PUT - replace /coffee-machines/{id}
     */
}
