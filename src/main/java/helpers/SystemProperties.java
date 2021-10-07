package helpers;

import java.io.IOException;
import java.util.Properties;

public class SystemProperties {
    private static Properties properties;

    public static void initProperties() {
        properties = new Properties();
        try {
            properties.load(SystemProperties.class.getClassLoader().getResourceAsStream(getCurrentLanguage()+ ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return System.getProperty(key);
    }

    public static String getCurrentLanguage() {
        return get("languagee");
    }

    public static String getProperty(String name) {
        if (properties == null) {
            initProperties();
        }
        return properties.getProperty(name);
    }
}
