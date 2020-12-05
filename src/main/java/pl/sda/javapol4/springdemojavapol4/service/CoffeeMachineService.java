package pl.sda.javapol4.springdemojavapol4.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.javapol4.springdemojavapol4.entity.CoffeeMachine;
import pl.sda.javapol4.springdemojavapol4.repository.CoffeeMachineRepository;

import java.util.List;

@Slf4j
@Service
public class CoffeeMachineService {

    private final CoffeeMachineRepository coffeeMachineRepository;

    public CoffeeMachineService(CoffeeMachineRepository coffeeMachineRepository) {
        this.coffeeMachineRepository = coffeeMachineRepository;
    }

    public CoffeeMachine findCoffeeMachineById(Long id) {
        var result = giveMeMyCoffeeMachines().stream()
            .filter(coffeeMachine -> coffeeMachine.getId() == id)
            .findFirst()
            .orElse(null);
        log.info("found coffee machine with id: [{}] = [{}]", id, result);

        return result;
    }

    public List<CoffeeMachine> giveMeMyCoffeeMachines() {
        var coffeeMachines = coffeeMachineRepository.myFavouritesCoffeeMachines();

        log.info("coffee machines: {}", coffeeMachines);

        return coffeeMachines;
    }
}
