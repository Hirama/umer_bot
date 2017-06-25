import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import java.util.Properties;


public class UmerBot extends TelegramLongPollingBot {

    Properties resourceBundle = PropertiesLoader.load("tg.properties");

    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage().hasText()) {
            CommandsSwitch.chooseAction(update.getMessage().getText());
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
