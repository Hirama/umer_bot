import org.telegram.telegrambots.api.objects.Update;

import java.util.ArrayList;
import java.util.Properties;
import java.util.stream.Stream;

public class FinalAnswer {
    private static Properties answers = PropertiesLoader.load("answers.properties");

    public static void reply(String answer, DeceasedProfile profile, Update update, UmerBot context){
        Long chatId = update.getMessage().getChatId();

        switch (answer){
            case "Есть":{
                MessageSender.send(chatId, "Вы лишили себя большого числа проблем", new ArrayList<>(), context);
                break;
            }
            case "Нет":{
                MessageSender.send(chatId, "Бесплатный участок: " + answers.getProperty("участок-бесплатный"),
                        new ArrayList<>(), context);
                MessageSender.send(chatId, "Платный участок: " + answers.getProperty("участок-платный"),
                        new ArrayList<>(), context);

                String[] alts = answers.getProperty("кремация-альтернатива").split(",");
                Stream.of( alts ).forEach( (alt)-> {
                    MessageSender.send(chatId, alt, new ArrayList<>(), context);
                });
                break;
            }
        }

        MessageSender.send(chatId, answers.getProperty("заключение"), new ArrayList<>(), context);
    }
}
