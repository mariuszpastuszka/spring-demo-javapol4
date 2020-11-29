package pl.sda.javapol4.springdemojavapol4.service;

//import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.javapol4.springdemojavapol4.repository.MyFirstRepository;

//@Component
@Service
@Slf4j
public class MyFirstService {

    private final MyFirstRepository myFirstRepository;

    public MyFirstService(MyFirstRepository myFirstRepository) {
        this.myFirstRepository = myFirstRepository;
    }

    public String giveMeMySecret() {
        var plainTextSecret = myFirstRepository.mySecret();
        log.info("plain text secret [{}]", plainTextSecret);

        return plainTextSecret.substring(0, plainTextSecret.length() / 2) + "******";
    }
}
