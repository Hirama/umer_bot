import org.telegram.telegrambots.api.objects.Update;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CategoryProcessor {
    private static Properties answers = PropertiesLoader.load("answers.properties");

    public static void setCategory(Category category, DeceasedProfile profile, Update update, UmerBot context){
        Long chatId = update.getMessage().getChatId();
        profile.category = category;
        switch (category){
            case Pensioner:{
                List<String> btns = new ArrayList<>();
                btns.add("Ветеран");
                btns.add("Не ветеран");
                MessageSender.send(chatId, "Кто умер?", btns, context);
                break;
            }
            case Unemployed:
            case Child:{
                HelpTypeRequester.request(profile, update, context);
                break;
            }
            case Employed:{
                MessageSender.send(chatId, answers.getProperty("работающий"), new ArrayList<>(), context );
            }
        }
    }
}
