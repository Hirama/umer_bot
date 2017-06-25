import org.telegram.telegrambots.api.objects.Update;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

public class TypeFunerealProcessor {
    private static Properties answers = PropertiesLoader.load("answers.properties");

    public static void process(String type, DeceasedProfile profile, Update update, UmerBot context){
        Long chatId = update.getMessage().getChatId();

        switch (type){
            case "Классические похороны":{
                MessageSender.send(chatId, "Варианты по ценам:", new ArrayList<>(), context);
                String[] priceOptions = answers.getProperty("похороны-классические").split(",");
                Stream.of(priceOptions).forEach((option)-> {
                    MessageSender.send(chatId, option, new ArrayList<>(), context);
                });


            }
            case "Кремация":{
                MessageSender.send(chatId, "Варианты по ценам:", new ArrayList<>(), context);
                String[] priceOptions = answers.getProperty("похороны-кремация").split(",");
                Stream.of(priceOptions).forEach((option)-> {
                    MessageSender.send(chatId, option, new ArrayList<>(), context);
                });
            }
        }

        List<String> btns = new ArrayList<>();
        btns.add("Есть");
        btns.add("Нет");
        MessageSender.send(chatId, "Есть ли у Вас участок на кладбище?", btns, context);
    }
}
