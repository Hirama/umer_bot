import org.telegram.telegrambots.api.objects.Update;

import java.util.Properties;


public class CommandsSwitch {
    public static void chooseAction(String message, DeceasedProfile profile, Update update, UmerBot context){

        switch(message){
            case "Пенсионер":
            case "Неработающий":
            case "Ребенок":
            case "Работающий":{
                Category category = Category.switchType(message);
                CategoryProcessor.setCategory(category, profile, update, context);
                break;
            }

            case "Ветеран":
            case "Не ветеран":{
                boolean isVeteran = "Ветеран".equals(message);
                break;
            }

            case "Получить выплату":
            case "Похоронить бесплатно":{
                HelpType helpType = HelpType.switchType(message);
                break;
            }
            default:
                System.out.println("Unknown command");
        }
    }
}
