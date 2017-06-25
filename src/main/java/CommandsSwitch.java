import java.util.Properties;


public class CommandsSwitch {
    private static Properties answers = PropertiesLoader.load("answers.properties");
    public static void chooseAction(String message){

        switch(message){
            case "Пенсионер":
            case "Неработающий":
            case "Ребенок":
            case "Работающий":{
                Category category = Category.switchType(message);
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
