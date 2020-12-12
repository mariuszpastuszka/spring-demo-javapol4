package pl.sda.javapol4.springdemojavapol4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.javapol4.springdemojavapol4.dto.GitHubRepo;
import pl.sda.javapol4.springdemojavapol4.service.GithubService;

import java.util.List;

@RestController
@RequestMapping("/github")
public class GithubController {

    private final GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/user-repos-string")
    public String userReposV1() {
        return githubService.giveUserReposAsString();
    }

    @GetMapping("/user-repos-custom")
    public List<GitHubRepo> userResposV2() {
        return githubService.findReposOfUser();
    }
}
