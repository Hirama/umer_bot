import java.util.Properties;


public class CommandsSwitch {
    private static Properties answers = PropertiesLoader.load("answers.properties");
    public static void chooseAction(String message){
        switch(message){

            default:
                System.out.println("Unknown command");
        }
    }
}
