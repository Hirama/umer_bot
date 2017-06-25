import org.telegram.telegrambots.api.objects.Update;

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
                profile.isVeteran = "Ветеран".equals(message);
                HelpTypeRequester.request(profile, update, context);
                break;
            }

            case "Получить выплату":
            case "Похоронить бесплатно":{
                HelpType helpType = HelpType.switchType(message);
                FinalAnswerGenerator.reply(helpType, profile, update, context);
                break;
            }
            default:
                System.out.println("Unknown command");
        }
    }
}
