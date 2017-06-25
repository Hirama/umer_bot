import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;


public class UmerBot extends TelegramLongPollingBot {

    private Properties resourceBundle = PropertiesLoader.load("tg.properties");
    private Map<Long, DeceasedProfile> cache = new ConcurrentHashMap<>();

    @Override
    public void onUpdateReceived(Update update) {
        Long userId = new Long( update.getMessage().getFrom().getId() );
        DeceasedProfile profile = null;
        if( !cache.containsKey(userId) || "/start".equals(update.getMessage().getText()) ){
            profile = new DeceasedProfile();
            cache.put(userId, profile);
        } else {
            profile = cache.get(userId);
        }

        if (update.getMessage().hasText()) {
            CommandsSwitch.chooseAction(update.getMessage().getText(), profile, update, this);
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
