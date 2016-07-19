package dev.priority.gmail.github;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GitHubApi {
    private static final Logger log = LoggerFactory.getLogger(GitHubApi.class);

    public String getUserData(String owner, String repositoryName, int numberPoolRequest) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.github.com/repos/" + owner + "/" + repositoryName + "/pulls/" + numberPoolRequest + "?access_token=9c3d0d236afd211a7955d7363c164136a84af76e";
        GitHabData gitHabData = restTemplate.getForObject(url, GitHabData.class);
        log.info(gitHabData.toString());
        return gitHabData.getBody();
    }

}
