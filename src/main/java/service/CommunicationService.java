package service;

import dev.priority.data.EmailConfiguration;
import dev.priority.data.EmailMessage;
import dev.priority.gmail.InterfaceGmailPost;
import dev.priority.gmail.MessageManager;
import dev.priority.gmail.github.GitHubApi;
import dev.priority.util.OnCompleteListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommunicationService {

    @Autowired
    EmailConfiguration emailConfiguration;

    @Autowired
    GitHubApi gitHubApi;


    public int findPoolReuestId() {
        return 3;
    }


    public boolean isRuleExistOnBody(String gitBody) {
        if (gitBody.equalsIgnoreCase("major")) {
            return true;
        }
        return false;
    }


}
