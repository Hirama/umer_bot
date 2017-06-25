import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by andrej on 25.06.17.
 */
public class UmerBot extends TelegramLongPollingBot {

    Properties resourceBundle = new Properties();

    {
        try {
            resourceBundle.load(new InputStreamReader(ClassLoader.getSystemResourceAsStream("tg.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage().getText().length() > 2) {
            SendMessage message = new SendMessage();
            message.setText("Умер");
            message.setChatId(update.getMessage().getChatId());
            try {
                sendMessage(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return resourceBundle.getProperty("alias");
    }

    @Override
    public String getBotToken() {
        return resourceBundle.getProperty("token");
    }

    @Override
    public void onClosing() {

    }

}
