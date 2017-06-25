import org.telegram.telegrambots.api.objects.Update;

import java.util.ArrayList;
import java.util.Properties;

public class FinalAnswerGenerator {
    private static Properties answers = PropertiesLoader.load("answers.properties");

    public static void reply(HelpType helpType, DeceasedProfile profile, Update update, UmerBot context){
        Long chatId = update.getMessage().getChatId();
        profile.helpType = helpType;

        switch (helpType){
            case GetPaid:{
                switch (profile.category){
                    case Pensioner:{
                        String answer = ( profile.isVeteran ) ? answers.getProperty("пенсионер-ветеран-получить_выплату") :
                                answers.getProperty("пенсионер-не_ветеран-получить_выплату");
                        MessageSender.send(chatId, answer, new ArrayList<>(), context);
                        break;
                    }
                    case Unemployed: {
                        String answer = answers.getProperty("безработный-получить_выплату");
                        MessageSender.send(chatId, answer, new ArrayList<>(), context);
                        break;
                    }
                    case Child:{
                        String answer = answers.getProperty("ребенок-выкидишь-получить_выплату");
                        MessageSender.send(chatId, answer, new ArrayList<>(), context);
                        break;
                    }
                }
                break;
            }
            case BuryFree:{
                switch (profile.category){
                    case Pensioner:{
                        String answer = ( profile.isVeteran ) ? answers.getProperty("пенсионер-ветеран-похоронить_бесплатно") :
                                answers.getProperty("пенсионер-не_ветеран-похоронить_бесплатно");
                        MessageSender.send(chatId, answer, new ArrayList<>(), context);
                        break;
                    }
                    case Unemployed: {
                        String answer = answers.getProperty("безработный-похоронить_бесплатно");
                        MessageSender.send(chatId, answer, new ArrayList<>(), context);
                        break;
                    }
                    case Child:{
                        String answer = answers.getProperty("ребенок-выкидишь-похоронить_бесплатно");
                        MessageSender.send(chatId, answer, new ArrayList<>(), context);
                        break;
                    }
                }
                break;
            }
        }
    }
}
