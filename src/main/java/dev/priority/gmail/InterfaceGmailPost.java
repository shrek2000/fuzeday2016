package dev.priority.gmail;

import dev.priority.data.EmailMessage;
import dev.priority.util.OnCompleteListener;

/**
 * Created by yoavbenishai on 19-Jul-16.
 */
public interface InterfaceGmailPost {
    public void init(OnCompleteListener<Void> onCompleted);
    public void register(OnCompleteListener<EmailMessage> onReceivedListenet);
    public void destroy(OnCompleteListener<Void> onCompleted);
}
