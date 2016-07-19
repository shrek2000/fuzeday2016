package dev.priority.gmail;

import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.ModifyMessageRequest;

import java.io.IOException;
import java.util.List;

public class MessageManager {

  /**
   * Modify the labels a message is associated with.
   *
   * @param service Authorized Gmail API instance.
   * @param userId User's email address. The special value "me"
   * can be used to indicate the authenticated user.
   * @param messageId ID of Message to Modify.
   * @param labelsToAdd List of label ids to add.
   * @param labelsToRemove List of label ids to remove.
   * @throws IOException
   */
   public static void modifyMessage(Gmail service, String userId, String messageId,
List<String> labelsToAdd, List<String> labelsToRemove) throws IOException {
      ModifyMessageRequest mods = new ModifyMessageRequest().setAddLabelIds(labelsToAdd)
         .setRemoveLabelIds(labelsToRemove);
      Message message = service.users().messages().modify(userId, messageId, mods).execute();

      System.out.println("Message id: " + message.getId());
      System.out.println(message.toPrettyString());
  }

  public static void markImportant(String messageId) {
       //modifyMessage
  }

}

