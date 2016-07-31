package dev.priority.gmail.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class GitHabData {
    private String url;

    private String id;

    private String body;

    private String commits;

    public GitHabData() {
    }

    public String getUrl() {
        return url;
    }

    public GitHabData setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getBody() {
        return body;
    }

    public GitHabData setBody(String body) {
        this.body = body;
        return this;
    }

    public String getId() {
        return id;
    }

    public GitHabData setId(String id) {
        this.id = id;
        return this;
    }

    public String getCommits() {
        return commits;
    }

    public GitHabData setCommits(String commits) {
        this.commits = commits;
        return this;
    }

    @Override
    public String toString() {
        return "GitHabData{" +
                "body='" + body + '\'' +
                ", url='" + url + '\'' +
                ", id='" + id + '\'' +
                ", commits='" + commits + '\'' +
                '}';
    }
}
