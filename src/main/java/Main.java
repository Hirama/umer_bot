import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.generics.BotSession;


public class Main {
    public static void main(String[] args) {


        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            BotSession session = telegramBotsApi.registerBot(new UmerBot());
            Runtime.getRuntime().addShutdownHook(new Thread(
                    ()->{
                        session.stop();
                        System.out.println("Феерический уход гуся.");
                    }));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
