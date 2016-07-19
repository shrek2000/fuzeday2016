package dev.priority.gmail;

import com.google.api.services.gmail.Gmail;
import dev.priority.data.EmailMessage;
import dev.priority.util.OnCompleteListener;

import java.io.IOException;

/**
 * Created by yoavbenishai on 19-Jul-16.
 */
public interface InterfaceGmailPost {
    public void init(OnCompleteListener<Void> onCompleted) throws IOException;
    public void register(OnCompleteListener<EmailMessage> onReceivedListenet);
    public void destroy(OnCompleteListener<Void> onCompleted);
    public Gmail getGmailService();
}
