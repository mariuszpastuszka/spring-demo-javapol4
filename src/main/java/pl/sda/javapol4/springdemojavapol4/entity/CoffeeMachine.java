package pl.sda.javapol4.springdemojavapol4.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoffeeMachine {

    private int capacityInMl;
    private String typeOfCoffee;
    private String vendor;
    private boolean milky;
}

// Valhalla
// List<boolean> // NOT :(
// List<Boolean>
