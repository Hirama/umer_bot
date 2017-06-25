import org.telegram.telegrambots.api.objects.Update;

public class CommandsSwitch {
    public static void chooseAction(String message, DeceasedProfile profile, Update update, UmerBot context){

        switch(message){
            case "/start":{
                StartCommand.run(profile, update, context);
                break;
            }

            case "Пенсионер":
            case "Безработный":
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
                HelpAnswerGenerator.reply(helpType, profile, update, context);
                break;
            }

            case "Классические похороны":
            case "Кремация":{
                TypeFunerealProcessor.process(message, profile, update, context);
                break;
            }

            case "Есть":
            case "Нет":{
                FinalAnswer.reply(message, profile, update, context);
                break;
            }

            default:
                System.out.println("Unknown command");
        }
    }
}
