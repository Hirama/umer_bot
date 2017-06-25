import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;


public class PropertiesLoader {
    public static Properties load(String resourceName){
        Properties props = new Properties();
        try {
            props.load(new InputStreamReader(ClassLoader.getSystemResourceAsStream("tg.properties")));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return props;
    }
}
