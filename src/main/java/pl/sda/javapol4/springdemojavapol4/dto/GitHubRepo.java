package pl.sda.javapol4.springdemojavapol4.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GitHubRepo {

    private String name;

    @JsonProperty("full_name")
    private String fullName;

    private RepoOwner owner;
}
