import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by andrej on 25.06.17.
 */
public class Main {
    public static void main(String[] args) {

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new UmerBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
