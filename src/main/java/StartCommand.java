import org.telegram.telegrambots.api.objects.Update;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StartCommand {
    private static Properties answers = PropertiesLoader.load("answers.properties");

    public static void run(DeceasedProfile profile, Update update, UmerBot context){
        Long chatId = update.getMessage().getChatId();
        List<String> btns = new ArrayList<>();
        btns.add("Пенсионер");
        btns.add("Безработный");
        btns.add("Ребенок");
        btns.add("Работающий");
        MessageSender.send(chatId, answers.getProperty("приветствие"), btns, context);
    }
}
