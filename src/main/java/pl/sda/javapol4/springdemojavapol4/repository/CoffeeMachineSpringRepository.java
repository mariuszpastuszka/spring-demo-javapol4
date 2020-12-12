package pl.sda.javapol4.springdemojavapol4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.sda.javapol4.springdemojavapol4.entity.CoffeeMachine;

public interface CoffeeMachineSpringRepository extends JpaRepository<CoffeeMachine, Long> {
}
