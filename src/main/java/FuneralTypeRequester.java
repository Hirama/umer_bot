import org.telegram.telegrambots.api.objects.Update;

import java.util.ArrayList;
import java.util.List;

public class FuneralTypeRequester {
    public static void request(DeceasedProfile profile, Update update, UmerBot context){
        Long chatId = update.getMessage().getChatId();
        List<String> btns = new ArrayList<>();
        btns.add("Классические похороны");
        btns.add("Кремация");
        MessageSender.send(chatId, "Выберите тип похорон", btns, context);
    }
}
