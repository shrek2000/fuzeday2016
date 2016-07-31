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
        String url = "https://api.github.com/repos/" + owner + "/" + repositoryName + "/pulls/" + numberPoolRequest + "?access_token=fad93025ddd00220f033a2c69aaa8da5798bd47a";
        GitHabData gitHabData = restTemplate.getForObject(url, GitHabData.class);
        log.info(gitHabData.toString());
        return gitHabData.getCommits();
    }

}
