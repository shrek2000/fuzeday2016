package service;

import dev.priority.data.EmailConfiguration;
import dev.priority.data.EmailMessage;
import dev.priority.gmail.InterfaceGmailPost;
import dev.priority.gmail.InterfaceGmailPostImpl;
import dev.priority.gmail.github.GitHubApi;
import dev.priority.util.OnCompleteListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommunicationService {

    @Autowired
    EmailConfiguration emailConfiguration;

    @Autowired
    GitHubApi gitHubApi;

    public CommunicationService() {
        initService();
    }

    public void initService()
    {

        final InterfaceGmailPost interfaceGmailPost = new InterfaceGmailPostImpl();

        try {
            interfaceGmailPost.init( new OnCompleteListener<Void>() {

                @Override
                public void onSuccess(Void aVoid) {
                    interfaceGmailPost.register(new OnCompleteListener<EmailMessage>() {

                        @Override
                        public void onSuccess(EmailMessage emailMessage) {
                            String gitBody =  gitHubApi.getUserData("tikalk","OSTK-playbook", findPoolReuestId(emailMessage.getBody()));
                            if (isRuleExistOnBody(gitBody)){
                                try {
                                    interfaceGmailPost.markImportant(emailMessage.getId());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        }

                        @Override
                        public void onError(int code, String message, Throwable exception) {

                        }
                    });
                }

                @Override
                public void onError(int code, String message, Throwable exception) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int findPoolReuestId(String body){

        return Integer.parseInt(body.substring(body.indexOf("pull/") + 5).split(" ")[0]);
    }


    public boolean isRuleExistOnBody(String gitBody){
        if (gitBody.equalsIgnoreCase("major")) {
            return true;
        }
        return false;
    }


}
