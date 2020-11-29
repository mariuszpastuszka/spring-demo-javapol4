package pl.sda.javapol4.springdemojavapol4.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pl.sda.javapol4.springdemojavapol4.entity.CoffeeMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Repository
public class CoffeeMachineRepository {

    public List<CoffeeMachine> myFavouritesCoffeeMachines() {
//        return null; - NEVER
        var result = new ArrayList<CoffeeMachine>(); // ArrayList<CoffeeeMachine>
//        var result2 = new ArrayList<>();
//        List<CoffeeMachine> result3 = new ArrayList<>();
//        List<CoffeeMachine> result4 = new ArrayList<CoffeeMachine>(); // Java 6
        var samsung = CoffeeMachine.builder()
            .capacityInMl(1_000)
            .vendor("Samsung")
            .milky(true)
            .build();
        result.add(samsung);

        var delonge = CoffeeMachine.builder()
            .vendor("Delonge")
            .capacityInMl(50)
            .milky(false)
            .build();
        result.add(delonge);

        var kafeteria = CoffeeMachine.builder()
            .capacityInMl(750)
            .milky(true)
            .vendor("home made")
            .build();
        result.add(kafeteria);

        return result;
    }
}
