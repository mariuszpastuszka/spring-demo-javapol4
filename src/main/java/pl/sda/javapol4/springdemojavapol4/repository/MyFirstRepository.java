package pl.sda.javapol4.springdemojavapol4.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class MyFirstRepository {

    private String mySecret = "haha";

    public String mySecret() {
        return mySecret;
    }
}
