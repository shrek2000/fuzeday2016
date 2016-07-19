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

    public  void test()
    {

        final InterfaceGmailPost interfaceGmailPost = null;//new InterfaceGmailPost();

        interfaceGmailPost.init(emailConfiguration.getUserName(), emailConfiguration.getPassword(),
                new OnCompleteListener<Void>() {

                    @Override
                    public void onSuccess(Void aVoid) {
                        interfaceGmailPost.register(new OnCompleteListener<EmailMessage>() {


                        @Override
                        public void onSuccess(EmailMessage emailMessage) {
                         String gitBody =  gitHubApi.getUserData("tikalk","OSTK-playbook", findPoolReuestId());
                            if (isRuleExistOnBody(gitBody)){
                                MessageManager.markImportant(emailMessage.getId());                            }

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
    }

            public int findPoolReuestId(){
            return 3;
            }


            public boolean isRuleExistOnBody(String gitBody){
                if (gitBody.equalsIgnoreCase("major")) {
                return true;
                }
            return false;
            }


}
