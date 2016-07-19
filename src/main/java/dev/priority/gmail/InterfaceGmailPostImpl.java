package dev.priority.gmail;

import dev.priority.data.EmailMessage;
import dev.priority.util.OnCompleteListener;
import org.springframework.stereotype.Component;

/**
 * Created by yoavbenishai on 19-Jul-16.
 */
@Component
public class InterfaceGmailPostImpl implements InterfaceGmailPost {
    @Override
    public void init(String user, String password, OnCompleteListener<Void> onCompleted) {

    }

    @Override
    public void register(OnCompleteListener<EmailMessage> onReceivedListenet) {

    }

    @Override
    public void destroy(OnCompleteListener<Void> onCompleted) {

    }
}
