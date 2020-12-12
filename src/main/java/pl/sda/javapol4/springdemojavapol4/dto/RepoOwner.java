package pl.sda.javapol4.springdemojavapol4.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepoOwner {

    private String login;

    @JsonProperty("avatar_url")
    private String avatarUrl;
}
