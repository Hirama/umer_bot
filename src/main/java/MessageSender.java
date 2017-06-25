import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboard;

import java.util.List;

/**
 * Created by andrej on 25.06.17.
 */
public class MessageSender {

    private static SendMessage createMessageForUser(Long chatId, String promt, List<String> btns) {
        ReplyKeyboard keyboard = KeyboardHelper.createReplyKeyboard(btns, true);
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(promt);
        if (null != keyboard) {
            sendMessage.setReplyMarkup(keyboard);
        }
        return sendMessage;
    }
}
