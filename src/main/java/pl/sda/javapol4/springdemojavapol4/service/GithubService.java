package pl.sda.javapol4.springdemojavapol4.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.javapol4.springdemojavapol4.dto.GitHubRepo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class GithubService {

    private static final String githubUrl = "https://api.github.com/users/{currentuser}/repos";

    private final RestTemplate myRestTemplate;
    private final String user;

    public GithubService(RestTemplate myRestTemplate, @Value("${github.user.login:unknown}") String user) {
        this.myRestTemplate = myRestTemplate;
        this.user = user;

        log.info("github current user: [{}]", user);
    }

    public String giveUserReposAsString() {
        Map<String, String> paramsWithValues = Map.of(
            "currentuser", user
        );
        var result = myRestTemplate.getForObject(githubUrl, String.class, paramsWithValues);
        log.info("user [{}] respos [{}]", user, result);

        return result;
    }

    public List<GitHubRepo> findReposOfUser() {
        Map<String, String> paramsWithValues = Map.of(
            "currentuser", user
        );


        GitHubRepo[] arrayWithResults = myRestTemplate.getForObject(githubUrl, GitHubRepo[].class, paramsWithValues);

        List<GitHubRepo> result = Arrays.asList(arrayWithResults);
        log.info("user [{}] respos [{}]", user, result);

        return result;
    }
}
