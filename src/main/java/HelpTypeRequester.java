import org.telegram.telegrambots.api.objects.Update;

import java.util.ArrayList;
import java.util.List;

public class HelpTypeRequester {
    public static void request(DeceasedProfile profile, Update update, UmerBot context){
        Long chatId = update.getMessage().getChatId();
        List<String> btns = new ArrayList<>();
        btns.add("Получить выплату");
        btns.add("Похоронить бесплатно");
        MessageSender.send(chatId, "Как Вам помочь?", btns, context);
    }
}
